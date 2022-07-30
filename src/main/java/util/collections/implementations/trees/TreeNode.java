package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeNodeI;

public class TreeNode<T> implements TreeNodeI<T> {

    private T key;
    private TreeNodeI<T> left;
    private TreeNodeI<T> right;

    TreeNode() {
        left = null;
        right = null;
    }

    TreeNode(T val) {
        this.key = val;
    }

    TreeNode(T val, TreeNodeI<T> left, TreeNodeI<T> right) {
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
        return (TreeNode<T>) left;
    }

    @Override
    public TreeNode<T> right() {
        return (TreeNode<T>) right;
    }

    @Override
    public void setRight(TreeNodeI<T> right) {
        this.right = right;
    }

    @Override
    public TreeNodeI<T> parent() {
        return null;
    }

    @Override
    public void setLeft(TreeNodeI<T> left) {
        this.left = left;
    }
}
