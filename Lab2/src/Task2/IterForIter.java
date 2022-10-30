package Task2;

import Task1.Iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterForIter<T> implements Iterator<T> {

    private final Iterator<T> innerIterator1;
    private final Iterator<T> innerIterator2;

    public IterForIter(Iter<T> innerIterator1, Iter<T> innerIterator2) {
        this.innerIterator1 = innerIterator1;
        this.innerIterator2 = innerIterator2;
    }

    @Override
    public boolean hasNext() {
        while (innerIterator1.hasNext()) return true;
        while (innerIterator2.hasNext()) return true;
        return false;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();

        while (innerIterator1.hasNext()) return innerIterator1.next();
        while (innerIterator2.hasNext()) return innerIterator2.next();
        return null;
    }
}
