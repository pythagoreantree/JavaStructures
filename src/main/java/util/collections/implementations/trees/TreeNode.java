package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeNodeI;

public class TreeNode<T> implements TreeNodeI<T> {

    public T key;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode() {}

    TreeNode(T val) {
        this.key = val;
    }

    TreeNode(T val, TreeNode left, TreeNode right) {
        this.key = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public TreeNodeI<T> left() {
        return left;
    }

    @Override
    public TreeNodeI<T> right() {
        return right;
    }

    @Override
    public TreeNodeI<T> parent() {
        return null;
    }
}
