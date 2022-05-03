package util.interfaces.collection;

import lang.collections.Jiterable;
import util.interfaces.Container;

public interface Collection<E> extends Container, Jiterable<E> {

    E[] toArray();

    E[] toArray(int length);

    /*Query operations*/

    boolean contains(E e);

    E get(int index);

    /*Modification operations*/

    E add(E e, int index);

    E add(E e);

    E set(E e, int index);

    E remove(int index);

    E remove(E e);

    void removeAllOccurences(E e);

    /*Bulk operations*/

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean replaceAll(Collection<? extends E> c, int startIndexThis, int startIndexCol, int length);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

}
