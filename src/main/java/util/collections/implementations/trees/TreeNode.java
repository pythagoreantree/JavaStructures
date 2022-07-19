package util.collections.implementations.trees;

public class TreeNode<T> {

    public T key;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode<T> parent; //for RB-Trees

    public int height = 1; //temporary measure to standartise the interface
    public byte color = 0; //for RB-trees

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
