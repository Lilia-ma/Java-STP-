import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Integer menuNav = 0;

    public static void main(String[] args) throws Exception {

        ArrayList<Order> orders = new ArrayList<>();

        Menu menu = new Menu();
        while (true)
        {
            menuNav = 0;
            System.out.println("Создать заказ нажмите 1");
            System.out.println("Посмотреть информацию по заказам нажмите 2");
            System.out.println("Закрыть заказ нажмите 3");
            System.out.println("Любой символ для выхода");
            input();
            switch (menuNav){

                case (2):
                    while (true){
                        System.out.println("Все существующие блюда");
                        menu.show();
                        System.out.println("Пишите номер чтобы изменить доступность блюда. Любую другую цифру для выхода в главное меню, любой символ для выхода из программы.");
                        try
                        {
                            input();
                            menu.changeAvailability(menuNav);
                        }
                        catch (IndexOutOfBoundsException ex) {break;}
                    }

                case (1):
                    System.out.println("Укажите номер столика");
                    input();
                    Order order = new Order(menuNav);
                    while (true)
                    {
                        try
                        {
                            menu.show();
                            order.showOrder();
                            System.out.println("Пишите номер позиции для добавления в заказ. 0 для подтверждения заказа. любой символ для выхода из программы.");
                            input();
                            order.add(menu.getMealByID(menuNav));
                        }
                        catch (IndexOutOfBoundsException ex) {
                            orders.add(order);
                            break;}
                    }

                    break;



                case (3):
                    int i = 1;
                    for (Order item : orders) {
                        System.out.println("Номер заказа: " + i);
                        item.showOrder();
                        i++;
                    }
                    System.out.println("Номер заказа, на который закрыть");
                    input();
                    orders.remove(menuNav - 1);
                    break;

            }
        }
    }

    private static void input(){
        try{
            menuNav = input.nextInt();
        }
        catch (InputMismatchException ex) {System.exit(0);}
    }
}