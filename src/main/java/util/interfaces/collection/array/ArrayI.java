package util.interfaces.collection.array;

import util.interfaces.collection.Collection;

import java.util.Comparator;

public interface ArrayI<E> extends Collection<E> {

    void sort(Comparator<? super E> c);

    int indexOf(E e);

    int lastIndexOf(E e);

    ArrayI<E> subArray(int fromIndex, int toIndex);

}
