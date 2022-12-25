package util.collections.interfaces.collection;

import util.collections.Container;

public interface Collection<T> extends Container, Iterable<T> {

    T[] getArray();

    T[] getArray(int length);

    /*Query operations*/

    boolean contains(T e);

    T get(int index);

    /*Modification operations*/

    void add(T e, int index);

    void add(T e);

    void set(T e, int index);

    void removeAtIndex(int index);

    void remove(T e);

    void removeFirst(T e);

    void removeLast(T e);

    void removeAllOccurences(T e);

    /*Bulk operations*/

    boolean containsAll(Collection<T> c);

    void addAll(Collection<T> c);

    void replaceAll(Collection<T> c);

    void replaceAll(Collection<T> c, int startIndexThis, int startIndexCol, int length);

    void removeAll(Collection<T> c);

    void retainAll(Collection<T> c);

}
