package util.collections.implementations.tree;

public class AVLNode<T> extends TreeNode<T> {

    private int height = 1;

    public AVLNode() {}

    public AVLNode(T val) {
        super(val);
    }

    public AVLNode(T val, int height) {
        super(val);
        this.height = height;
    }

    public int height() {
        return height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public AVLNode<T> left() {
        return (AVLNode<T>) super.left();
    }


    @Override
    public AVLNode<T> right() {
        return (AVLNode<T>) super.right();
    }


}
