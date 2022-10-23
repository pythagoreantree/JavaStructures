package util.collections.implementations.trees;

import org.junit.jupiter.api.Test;
import util.collections.utils.TreeUtils;
import util.collections.implementations.tree.RedBlackTree;

class RedBlackTreeTest {

    @Test
    void add() {
        RedBlackTree<Integer> rbtree = new RedBlackTree<>();
        rbtree.add(7);
        rbtree.add(1);
        rbtree.add(3);
        rbtree.add(4);
        TreeUtils.printInOrderTraversal(rbtree);

//        rbtree.remove(3);
//        TreeUtils.printInOrderTraversal(rbtree);
    }
}