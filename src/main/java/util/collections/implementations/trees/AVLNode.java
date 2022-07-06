package util.collections.implementations.trees;

public class AVLNode<T> extends TreeNode<T>{

    public int height = 1;

    public AVLNode() {}

    public AVLNode(T val) {
        super(val);
    }

    public AVLNode(T val, int height) {
        super(val);
        this.height = height;
    }
}
