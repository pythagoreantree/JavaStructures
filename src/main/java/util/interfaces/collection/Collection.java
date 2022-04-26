package util.interfaces.collection;

import util.interfaces.Container;

public interface Collection<E> extends Container, Iterable<E> {

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean contains(Object key);

    boolean containsAll(Collection<?> c);

    boolean add(E e);

    boolean addAtIndex(int index, E e);

    boolean addAll(Collection<? extends E> c);

    boolean replace(int index, E e);

    boolean replaceAll(Collection<? extends E> c, int startIndexThis, int startIndexCol, int length);

    boolean remove(E e);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

}
