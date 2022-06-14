package util.collections.interfaces.collection;

import lang.collections.Jiterable;
import util.collections.Container;

public interface Collection<E> extends Container, Jiterable<E> {

    Object[] toArray();

    Object[] toArray(int length);

    /*Query operations*/

    boolean contains(E e);

    E get(int index);

    /*Modification operations*/

    void add(E e, int index);

    void add(E e);

    void set(E e, int index);

    void remove(int index);

    void remove(E e);

    void removeAllOccurences(E e);

    /*Bulk operations*/

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean replaceAll(Collection<? extends E> c, int startIndexThis, int startIndexCol, int length);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

}
