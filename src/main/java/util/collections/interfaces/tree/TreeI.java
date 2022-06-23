package util.collections.interfaces.tree;


import util.collections.implementations.trees.TreeNode;

public interface TreeI<T> {

    TreeNode<T> search(T key);

    void insert(T key);

    void delete(T key);

    TreeNode<T> getRoot();

}
