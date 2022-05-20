package util.collections;

import java.util.Iterator;

public interface Jiterator<E> extends Iterator<E> {

    boolean hasPrevious();

    E previous();

    int nextIndex();

    int previousIndex();

    void add(E e);

    void set(E e);

}
