package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeNodeI;

public class RedBlackNode<T> extends TreeNode<T> {

    public static final byte RED = Byte.valueOf("1");
    public static final byte BLACK = Byte.valueOf("0");

    private RedBlackNode<T> parent;
    private byte color = BLACK;

    RedBlackNode(){
        super();
        parent = null;
    }

    RedBlackNode(T key, TreeNodeI<T> left, TreeNodeI<T> right) {
        super(key, left, right);
    }

    @Override
    public RedBlackNode<T> left() {
        return (RedBlackNode<T>) super.left();
    }

    @Override
    public RedBlackNode<T> right() {
        return (RedBlackNode<T>) super.right();
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
