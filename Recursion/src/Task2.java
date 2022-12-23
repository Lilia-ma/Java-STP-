import java.util.Arrays;

public class Task2 {
    public static void taskTwo() {

        //  Создаем массив
        int n = 10000000;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 100);
        }

        // Сортировка массива
        Arrays.sort(array);

        long start = System.nanoTime();
        Enumeration(array, 60);
        long finish = System.nanoTime();
        System.out.println("Время по методу перебора: " + (double) (finish - start));


        start = System.nanoTime();
        Recursion(array, 60, 0, array.length);
        finish = System.nanoTime();
        System.out.println("Время по двоичному методу: " + (double) (finish - start));
    }

    public static int Enumeration(int[] array, int x) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int Recursion(int[] array, int x , int i1, int i2) {

        int middle = (i1 + i2) / 2;

        if (i2 <= i1) return -1;

        if (array[middle] == x) {
            return middle;

        } else if (array[middle] > x) {
            return Recursion(array, x, i1, middle - 1);
        } else {
            return Recursion(array, x, middle + 1, i2);
        }
    }
}
