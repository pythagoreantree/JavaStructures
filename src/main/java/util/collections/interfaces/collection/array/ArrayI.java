package util.collections.interfaces.collection.array;

import util.collections.interfaces.collection.Collection;

public interface ArrayI<E> extends Collection<E> {

//    void sort(Comparator<? super E> c);

    int indexOf(E e);

    int lastIndexOf(E e);

    ArrayI<E> subArray(int fromIndex, int toIndex);

}
