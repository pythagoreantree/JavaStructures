package util.collections.interfaces.collection.array;

import util.collections.interfaces.collection.Collection;

public interface ArrayI<T> extends Collection<T> {

//    void sort(Comparator<? super T> c);

    int indexOf(T e);

    int lastIndexOf(T e);

    ArrayI<T> subArray(int fromIndex, int toIndex);

}
