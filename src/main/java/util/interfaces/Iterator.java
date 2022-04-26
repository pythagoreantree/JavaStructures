package util.interfaces;

public interface Iterator<E> {

    boolean hasNext();

    boolean hasPrevious();

    E next();

    E previous();

    int nextIndex();

    int previousIndex();

    void add(E e);

    void set(E e);

    void remove();

}
