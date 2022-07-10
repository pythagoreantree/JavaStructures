package util.collections.implementations.trees;

public class TreeNode<T> {

    public T key;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public int height = 1; //temporary measure to standartise the interface

    TreeNode() {}

    TreeNode(T val) {
        this.key = val;
    }

    TreeNode(T val, TreeNode left, TreeNode right) {
        this.key = val;
        this.left = left;
        this.right = right;
    }
}
