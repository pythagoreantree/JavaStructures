package util.collections.implementations.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void add() {
        AVLTree<Integer> tree = new AVLTree();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        tree.inOrderTraversal();
    }
}