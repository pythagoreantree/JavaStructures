package util.collections.implementations.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.collections.utils.TreeUtils;
import util.collections.implementations.tree.BinaryTree;
import util.collections.implementations.tree.TreeNode;

class BinaryTreeTest {

    @Test
    void addKey() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 1; i <= 10; i++){
            tree.add(i);
        }
        TreeUtils.printPostOrderTraversal(tree);
    }

    @Test
    void removeKey() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 1; i <= 10; i++){
            tree.add(i);
        }
        TreeUtils.printInOrderTraversal(tree);
        tree.remove(1);
        TreeUtils.printInOrderTraversal(tree);
    }

    @Test
    void search() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 1; i <= 10; i++){
            tree.add(i);
        }
        TreeUtils.printInOrderTraversal(tree);
        TreeNode search13 = tree.search(13);
        Assertions.assertNull(search13);
        TreeNode search4 = tree.search(8);
        Assertions.assertNotNull(search4);
        Assertions.assertEquals(8, search4.key());
    }
}