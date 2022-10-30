package Task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class  Iter<T> implements Iterator<T>{
    private final int size;
    private int position = 0;
    private int row = 0;
    private int col = 0;
    private final T[][] mas;

    public Iter(T[][] mas) {
        this.mas = mas;
        this.size = countElements(mas);
    }

    private int countElements(T[][] mas) {
        int count = 0;
        for (T[] row : mas) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
        if (position >= size) {
            throw new NoSuchElementException();
        }
        T element = mas[row][col];
        position++;
        col++;
        while (row < mas.length && col >= mas[row].length) {
            col = 0;
            row++;
        }
        return element;
    }
}
