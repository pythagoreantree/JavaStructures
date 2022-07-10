package util.collections.implementations.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.collections.TreeUtils;

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
        TreeUtils.printInOrderTraversal(tree);
    }

    @Test
    void search(){
        AVLTree<Integer> tree = new AVLTree();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        TreeNode ans = tree.search(30);
        Assertions.assertEquals(30, ans.key);
        ans = tree.search(1);
        Assertions.assertNull(ans);
    }

    @Test
    void remove(){
        AVLTree<Integer> tree = new AVLTree();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        tree.remove(30);
        TreeUtils.printInOrderTraversal(tree);
        tree.remove(2);
        TreeUtils.printInOrderTraversal(tree);
    }
}