package util.collections.implementations.trees;

import org.junit.jupiter.api.Test;
import util.collections.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    @Test
    void add() {
        RedBlackTree<Integer> rbtree = new RedBlackTree<>();
        rbtree.add(2);
        rbtree.add(1);
        rbtree.add(3);
        TreeUtils.printInOrderTraversal(rbtree);

//        rbtree.remove(3);
//        TreeUtils.printInOrderTraversal(rbtree);
    }
}