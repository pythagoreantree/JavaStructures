package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeNodeI;

public class TreeNode<T> implements TreeNodeI<T> {

    private T key;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    TreeNode() {
        left = null;
        right = null;
    }

    TreeNode(T val) {
        this.key = val;
    }

    TreeNode(T val, TreeNode left, TreeNode right) {
        this.key = val;
        this.left = left;
        this.right = right;
    }

    public T key() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public TreeNode<T> left() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    @Override
    public TreeNode<T> right() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public TreeNodeI<T> parent() {
        return null;
    }
}
