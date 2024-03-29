package util.collections.interfaces.tree;

public interface TreeNodeI<T> {

    TreeNodeI<T> left();

    TreeNodeI<T> right();

    T key();

    TreeNodeI<T> parent();

    void setLeft(TreeNodeI<T> left);

    void setRight(TreeNodeI<T> right);

}
