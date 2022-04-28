package util.interfaces.collection;

import lang.collections.Jiterable;
import util.interfaces.Container;

public interface Collection<E> extends Container, Jiterable<E> {

    E[] toArray();

    E[] toArray(E[] arr);

    /*Query operations*/

    boolean contains(E e);

    E get(int index);

    /*Modification operations*/

    E add(E e, int index);

    E add(E e);

    E set(E e, int index);

    E remove(E e);

    E remove(int index);

    /*Bulk operations*/

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean replaceAll(Collection<? extends E> c, int startIndexThis, int startIndexCol, int length);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

}
