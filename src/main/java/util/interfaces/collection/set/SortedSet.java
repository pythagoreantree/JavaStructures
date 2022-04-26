package util.interfaces.collection.set;

import java.util.Comparator;

public interface SortedSet<E> extends Set<E> {

    Comparator<? super E> comparator();

    SortedSet<E> subSet(E fromElement, E toElement);

    SortedSet<E> subSetBefore(E toElement);

    SortedSet<E> subSetAfter(E fromElement);

    E lowest();

    E highest();
}
