package util.collections.interfaces.tree;


import util.collections.implementations.trees.TreeNode;

public interface TreeI<T> {

    TreeNode<T> search(T key);

    void add(T key);

    void remove(T key);

    TreeNode<T> getRoot();

}
