package util.collections.implementations.trees;

public final class BlackNode<T> extends RedBlackNode<T>{

    public BlackNode() {
        super();
        setColor(RedBlackNode.BLACK);
        setLeft(null);
        setRight(null);
    }
}
