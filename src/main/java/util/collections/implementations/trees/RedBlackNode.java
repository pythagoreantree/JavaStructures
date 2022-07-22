package util.collections.implementations.trees;

public class RedBlackNode<T> extends TreeNode<T> {

    private RedBlackNode<T> parent;
    private byte color = 0;

    RedBlackNode(T key, TreeNode left, TreeNode right) {
        super.setKey(key);
        this.left = left;
        this.right = right;
    }

    @Override
    public RedBlackNode<T> left() {
        return (RedBlackNode<T>) super.left();
    }

    public void setLeft(RedBlackNode<T> left) {
        this.left = left;
    }

    @Override
    public RedBlackNode<T> right() {
        return (RedBlackNode<T>) super.right();
    }

    public void setRight(RedBlackNode<T> right) {
        this.right = right;
    }

    @Override
    public RedBlackNode<T> parent() {
        return parent;
    }

    public byte color() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }
}
