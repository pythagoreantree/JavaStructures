package util.collections.implementations.trees;

import org.junit.jupiter.api.Test;
import util.collections.TreeUtils;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTest {

    @Test
    void add() {
        SplayTree<Integer> tree = new SplayTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        TreeUtils.printPreOrderTraversal(tree);
//        TreeNode<Integer> ans = tree.search(27);
//        System.out.println(ans.key);
        tree.remove(50);
        TreeUtils.printPreOrderTraversal(tree);
    }
}