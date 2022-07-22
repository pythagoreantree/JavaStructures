package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeNodeI;

public class RedBlackNode<T> extends TreeNode<T> {

    public TreeNode<T> parent;
    public byte color = 0;

    @Override
    public TreeNodeI<T> parent() {
        return parent;
    }

}
