package util.collections.implementations.trees;

import org.junit.jupiter.api.Test;
import util.collections.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    @Test
    void add() {
        RedBlackTree<Integer> rbtree = new RedBlackTree<>();
        rbtree.add(1);
        rbtree.add(2);
        rbtree.add(3);
        rbtree.add(4);
        rbtree.add(5);
        rbtree.add(6);
        TreeUtils.printInOrderTraversal(rbtree);
    }
}