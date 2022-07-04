package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeI;

public class BinarySearchTree<T> implements TreeI<T> {

    TreeNode<T> root;

    @Override
    public TreeNode<T> search(T key) {
        TreeNode node = root;
        while (node != null && node.key != key){
            Comparable<T> nkey = (Comparable) node.key;
            if (nkey.compareTo(key) > 0)
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }

    @Override
    public void add(T key) {
        add(root, key);
    }

    private TreeNode add(TreeNode<T> node, T key){
        if(node == null) {
            TreeNode leaf = new TreeNode(key);
            return leaf;
        }
        Comparable<T> nkey = (Comparable) node.key;
        if (nkey.compareTo(key) > 0) {
            node.left = add(node.left, key);
        } else {
            node.right = add(node.right, key);
        }
        return node;
    }

    @Override
    public void remove(T key) {

    }

    public TreeNode remove(TreeNode node, T key) {
        if (node == null)
            return null;

        Comparable<T> nkey = (Comparable) node.key;
        if (nkey.compareTo(key) == 0) {
            if (node.right == null)
                return node.left;
            else if (node.left == null)
                return node.right;

            TreeNode<T> inOrderSuccessor = node.right;
            while (inOrderSuccessor.left != null)
                inOrderSuccessor = inOrderSuccessor.left;

            node.key = inOrderSuccessor.key;
            node.right = remove(node.right, inOrderSuccessor.key);
        } else if (nkey.compareTo(key) < 0){
            node.right = remove(node.right, key);
        } else {
            node.left = remove(node.left, key);
        }
        return node;
    }

    @Override
    public TreeNode<T> getRoot() {
        return null;
    }
}
