package util.collections.implementations.tree;

import util.collections.interfaces.tree.TreeI;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> implements TreeI<T> {
    public TreeNode<T> root;

    public BinaryTree() {}

    public BinaryTree(T key) {
        if (root == null)
            root = new TreeNode<>(key);
        else
            //I don't want to update key if root already exists
            throw new RuntimeException("Tree is already constructed.");
    }

    /*
    * O(n) time complexity
    * */
    @Override
    public TreeNode search(T key) {
        return search(root, key);
    }

    public TreeNode search(TreeNode<T> node, T key) {
        if (node == null)
            return null;

        if (node.key() == key){
            return node;
        }
        TreeNode left = search(node.left(), key);
        TreeNode right = search(node.right(), key);

        if (left != null && left.key() == key)
            return left;
        if (right != null && right.key() == key)
            return right;
        return null;
    }


    /*
    * O(n) time complexity
    * */
    @Override
    public void add(T key) {
        if (root == null) {
            root = new TreeNode<T>(key);
            return;
        }
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode<T> node = q.poll();
            if (node.left() == null) {
                node.setLeft(new TreeNode<T>(key));
                break;
            } else {
                q.add(node.left());
            }

            if (node.right() == null) {
                node.setRight(new TreeNode<T>(key));
                break;
            } else {
                q.add(node.right());
            }
        }
    }

    /*
    * O(n) time complexity
    * */
    @Override
    public void remove(T key) {
        //here may be also if key == null then exception
        if (root == null)
            return;

        if (root.left() == null && root.right() == null) {
            if (root.key() == key) {
                root = null;
                return;
            } else {
                //here may be I need an exception
                return;
            }
        }

        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);
        TreeNode<T> keyNode = null;
        TreeNode<T> node = null;
        TreeNode<T> parent = null;

        while (!q.isEmpty()) {
            node = q.poll();

            if (node.key() == key)
                keyNode = node;

            if (node.left() != null) {
                parent = node;
                q.add(node.left());
            }

            if (node.right() != null){
                parent = node;
                q.add(node.right());
            }
        }

        //here may be I need an exception if keyNode is not found
        if (keyNode != null) {
            keyNode.setKey(node.key());
            if (parent.left() == node)
                parent.setLeft(null);
            else if (parent.right() == node)
                parent.setRight(null);

        }
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
