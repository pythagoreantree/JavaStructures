package lang.collections;

import util.interfaces.Iterator;

public interface Iterable<T> {

    Iterator<T> iterator();

    Iterator<T> iterator(int index);
}
