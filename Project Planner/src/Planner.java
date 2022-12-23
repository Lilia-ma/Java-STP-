import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Planner {
    ArrayList<Object> objectives;
    int id_counter;
    Scanner scanner;

    Planner() {
        this.objectives = new ArrayList<>();
        this.id_counter = 0;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Выберите номер действие, которое хотите сделать:");
        System.out.println("1 - Создать задание");
        System.out.println("2 - Удалить задание");
        System.out.println("3 - Отредактировать задание");
        System.out.println("4 - Просмотреть список ВСЕХ заданий");
        System.out.println("5 - Просмотреть список ВЫПОЛНЕННЫХ заданий ");
        System.out.println("6 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий");
        System.out.println("7 - Просмотреть список ВЫПОЛНЕННЫХ заданий по ДАТЕ");
        System.out.println("8 - Посмотреть список СОЗДАННЫХ заданий по ДАТЕ");
        System.out.println("9 - Просмотреть детальную информацию о задании");
        System.out.println("10 - Выполнить");
        System.out.println("0 - Выход");

        while (true) {
            switch (this.scanner.nextLine()) {
                case "1": {
                    this.CreateObjective();
                    break;
                }
                case "2": {
                    int objectiveUid = this.GetObjective();
                    if (objectiveUid != 0) {
                        this.DeleteObjective(objectiveUid);
                    }
                    break;
                }
                case "3": {
                    int ObjectiveUid = this.GetObjective();
                    if (ObjectiveUid != 0) {
                        this.CorrectObjective(ObjectiveUid);
                    }
                    break;
                }
                case "4": {
                    this.ShowAllObjective();
                    break;
                }
                case "5": {
                    this.ShowCompletedObjectives();
                    break;
                }
                case "6": {
                    this.ShowNotCompletedObjectives();
                    break;
                }
                case "7": {
                    Date date = this.GetDate();
                    this.ShowCompletedObjectives(date);
                    break;
                }
                case "8": {
                    Date date = this.GetDate();
                    this.ShowAllObjective(date);
                    break;
                }
                case "9": {
                    int ObjectiveUid = this.GetObjective();
                    if (ObjectiveUid != 0) {
                        this.ShowObjectivesDetailInformation(ObjectiveUid);
                    }
                    break;

                }
                case "10": {
                    int ObjectiveUid = this.GetObjective();
                    if (ObjectiveUid != 0) {
                        this.CompleteObjective(ObjectiveUid);
                    }
                    break;
                }

                case "0": {
                    return;
                }
                default: {
                    System.out.println("Вы ввели неверную цифру");
                    break;
                }
            }
        }
    }

    //Task1
    public void CreateObjective() {
        System.out.println("Введите наименование задания:");
        String title = this.scanner.nextLine();
        System.out.println("Введите описание задания:");
        String description = this.scanner.nextLine();
        this.objectives.add(new Object(this.id_counter++, title, description));
        System.out.println("Задание добавлено");
    }

    public void CompleteObjective(int ObjectiveUid) {
        int task_index = this.GetObjectiveById(ObjectiveUid);
        this.objectives.get(task_index).completed = new Date();
    }

    public void CorrectObjective(int ObjectiveUid) {
        Object obj = this.objectives.get(this.GetObjectiveById(ObjectiveUid));
        System.out.println("Что хотите изменить?");
        System.out.println("1 - Заголовок");
        System.out.println("2 - Описание");
        System.out.println("0 - Я передумал/а что-то менять");
        switch (this.scanner.nextLine()) {
            case "1": {
                System.out.println("Введите наименование");
                obj.header = this.scanner.nextLine();
            }
            case "2": {
                System.out.println("Введите описание");
                obj.description = this.scanner.nextLine();
            }
            case "0": {
                System.out.println("Выход из редактирования");
            }
            default: {
                System.out.println("Вы ввели неверную цифру");
            }
        }
    }


    private Date GetDate() {
        System.out.println("Введите дату (Month day, yyyy: Dec 23, 2022)):");
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        String input = scanner.nextLine();
        try {
            return format.parse(input);
        } catch (ParseException pe) {
            System.out.println("Неверный ввод");
            return new Date();
        }
    }

    private int GetObjective() {
        System.out.println("Введите номер задания");
        try {
            return Integer.parseInt(this.scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Неверный ввод номера задания");
        }
        return 0;
    }


    private int GetObjectiveById(int ObjectiveUid) {
        for (int i = 0; i < this.objectives.size(); i++) {
            if (Objects.equals(this.objectives.get(i).number, ObjectiveUid)) {
                return i;
            }
        }
        return 0;
    }



    public void ShowObjectivesDetailInformation(int ObjectiveUid) {
        Object obj = this.objectives.get(this.GetObjectiveById(ObjectiveUid));
        System.out.println("Наименование: ");
        System.out.println(obj.header);
        System.out.println("Описание:");
        System.out.println(obj.description);
        System.out.println("Дата создания:");
        System.out.println(obj.created);
        System.out.println("Дата выполнения:");
        System.out.println(obj.completed);
    }

    public void ShowAllObjective() {
        System.out.println("Все задания:");
        for (Object obj : this.objectives) {
            System.out.println("id"+obj.number + ". " + obj.header);
        }
    }

    public void ShowAllObjective(Date date) {
        System.out.println("Все задания по дате " + date + ":");
        for (Object obj : this.objectives) {
            if (obj.created.getDate() == date.getDate()) {
                System.out.println("id"+obj.number + ". " + obj.header);
            }
        }
    }


    public void ShowCompletedObjectives() {
        System.out.println("Выполненные задания:");
        for (Object obj : this.objectives) {
            if (obj.completed != null) {
                System.out.println("id"+obj.number + ". " + obj.header);
            }
        }
    }

    public void ShowCompletedObjectives(Date date) {
        System.out.println("Выполненные задания по дате " + date + ":");
        for (Object obj : this.objectives) {
            if (obj.completed != null) {
                if (obj.created.getDate() == date.getDate()) {
                    System.out.println("id"+obj.number + ". " + obj.header);
                }
            }
        }
    }

    public void ShowNotCompletedObjectives() {
        System.out.println("Невыполненные задания:");
        for (Object obj : this.objectives) {
            if (obj.completed == null) {
                System.out.println("id"+obj.number + ". " + obj.header);
            }
        }
    }


    public void ShowNotCompletedObjectives(Date date) {
        System.out.println("Невыполненные задания по дате " + date + ":");
        for (Object obj : this.objectives) {
            if (obj.completed == null) {
                if (obj.created.getDate() == date.getDate()) {
                    System.out.println("id"+obj.number + ". " + obj.header);
                }
            }
        }
    }


    public void DeleteObjective(int ObjectiveUid) {
        this.objectives.remove(this.GetObjectiveById(ObjectiveUid));
    }


}