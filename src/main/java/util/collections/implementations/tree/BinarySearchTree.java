package util.collections.implementations.tree;

import util.collections.interfaces.tree.TreeI;

public class BinarySearchTree<T> implements TreeI<T> {

    protected TreeNode<T> root;

    /*
    * O(h) time complexity
    * */
    @Override
    public TreeNode<T> search(T key) {
        TreeNode node = root;
        while (node != null && node.key() != key){
            Comparable<T> nkey = (Comparable) node.key();
            if (nkey.compareTo(key) > 0)
                node = node.left();
            else
                node = node.right();
        }
        return node;
    }

    /*
    * O(h) time complexity
    * */
    @Override
    public void add(T key) {
        add(root, key);
    }

    private TreeNode<T> add(TreeNode<T> node, T key){
        if(node == null) {
            TreeNode leaf = new TreeNode(key);
            return leaf;
        }
        Comparable<T> nkey = (Comparable) node.key();
        if (nkey.compareTo(key) > 0) {
            node.setLeft(add(node.left(), key));
        } else {
            node.setRight(add(node.right(), key));
        }
        return node;
    }

    /*
    * Also looks like being O(h)
    * */
    @Override
    public void remove(T key) {
        remove(root, key);
    }

    public TreeNode<T> remove(TreeNode<T> node, T key) {
        if (node == null)
            return null;

        Comparable<T> nkey = (Comparable) node.key();
        if (nkey.compareTo(key) > 0){
            node.setLeft(remove(node.left(), key));
        } else if (nkey.compareTo(key) < 0) {
            node.setRight(remove(node.right(), key));
        } else {
            if (node.right() == null)
                return node.left();
            else if (node.left() == null)
                return node.right();

            TreeNode<T> inOrderSuccessor = node.right();
            while (inOrderSuccessor.left() != null)
                inOrderSuccessor = inOrderSuccessor.left();

            node.setKey(inOrderSuccessor.key());
            node.setRight(remove(node.right(), inOrderSuccessor.key()));
        }
        return node;
    }

    @Override
    public TreeNode<T> getRoot() {
        return root;
    }

    @Override
    public int size() {
        return 0;
    }
}
