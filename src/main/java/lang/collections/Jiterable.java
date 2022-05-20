package lang.collections;

import util.collections.Jiterator;

public interface Jiterable<T> extends Iterable<T> {

    Jiterator<T> jiterator();

    Jiterator<T> jiterator(int index);

}
