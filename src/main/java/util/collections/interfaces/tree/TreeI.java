package util.collections.interfaces.tree;


public interface TreeI<T> {

    TreeNodeI<T> search(T key);

    void add(T key);

    void remove(T key);

    TreeNodeI<T> getRoot();

    int size();

}
