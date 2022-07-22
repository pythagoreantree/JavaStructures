package util.collections.implementations.trees;

public final class BlackNode<T> extends RedBlackNode<T>{

    public BlackNode() {
        this.color = 0;
        setLeft(null);
        setRight(null);
    }
}
