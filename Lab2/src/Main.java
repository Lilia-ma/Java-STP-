import Task1.Iter;
import Task2.IterForIter;
import Task7.FrequencyDictionary;

import java.util.*;

public class Main {
    public static Random rnd = new Random();

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }


    public static void addMillionItems(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(rnd.nextInt(10000));
            linkedList.add(rnd.nextInt(10000));
        }
    }

    public static void selectItems(ArrayList<Integer> arrayList) {
        for (int i = 0; i < 100000; i++) {
            arrayList.get(rnd.nextInt(arrayList.size()));
        }
    }

    public static void main(String[] args) {
        // Задание 1
        Integer[][] nums = {{1, 2, 3, 123}, {1, 0, 1, 5}, {7, 7, 7, 3}};
        Iter<Integer> InterNums = new Iter<>(nums);
        while (InterNums.hasNext()) {
            System.out.println(InterNums.next());
        }

        // Задание 2
        Iter<Integer> customInterNums2 = new Iter<>(nums);
        Iter<Integer> customInterNums3 = new Iter<>(nums);

        IterForIter<Integer> iterForIter = new IterForIter<>(customInterNums2, customInterNums3);

        while (iterForIter.hasNext()) {
            System.out.println(iterForIter.next());
        }

        // Задание 3-4
        ArrayList<String> stringArrayList = new ArrayList<String>();

        stringArrayList.add("9");
        stringArrayList.add("9");
        stringArrayList.add("9");

        Iterator<String> stringIterator = stringArrayList.iterator();

        FlatIterator flatIterator = new FlatIterator(stringIterator);

        while (flatIterator.hasNext()) {
            System.out.println(flatIterator.next());
        }

        // Задание 5
        Collection<String> stringCollection = new ArrayList<>();

        stringCollection.add("python");
        stringCollection.add("java");
        stringCollection.add("python");
        stringCollection.add("C#");

        System.out.println("\nДо проверки на дубликаты-"+stringCollection);
        stringCollection = removeDuplicates(stringCollection);
        System.out.println("Итог-"+stringCollection);

        // Задание 6
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        System.out.println("\n1 000 000 случайных элементов");
        addMillionItems(integerArrayList, integerLinkedList);
        System.out.println("1 000 000 случайных элементов добавлены");

        ArrayList<Integer> integerArrayList2 = new ArrayList<>();
        integerArrayList2.add(1);
        integerArrayList2.add(2);
        integerArrayList2.add(3);

        System.out.println("100 000 элементов");
        selectItems(integerArrayList2);
        System.out.println("100 000 элементов выбраны");

        System.out.println("выбрать 100 000 элементов быстрее, чем добавить миллион");

        // Задание 7
        FrequencyDictionary fd = new FrequencyDictionary();
        fd.analyze("я пытаюсь понять джаву");
        System.out.println("\n"+fd.getDictionary());




    }

}
