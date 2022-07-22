package util.collections.implementations.trees;

public class RedBlackNode<T> extends TreeNode<T> {

    public static final byte RED = Byte.valueOf("1");
    public static final byte BLACK = Byte.valueOf("0");

    private RedBlackNode<T> parent;
    private byte color = BLACK;

    RedBlackNode(){
        super();
        parent = null;
    }

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
