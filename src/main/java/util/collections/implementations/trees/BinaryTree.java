package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeI;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> implements TreeI<T> {
    public TreeNode<T> root;

    @Override
    public TreeNode search(T key) {
        return search(root, key);
    }

    public TreeNode search(TreeNode<T> node, T key) {
        if (node == null)
            return null;
        if (node.key == key){
            return node;
        }
        search(node.left, key);
        search(node.right, key);
        return null;
    }

    @Override
    public void insert(T key) {
        //need to test thoroughly
        if (root == null) {
            root = new TreeNode<T>(key);
            return;
        }
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode<T> node = q.poll();

            if (node.left == null) {
                node.left = new TreeNode<T>(key);
                break;
            } else {
                q.add(node.left);
            }

            if (node.right == null) {
                node.right = new TreeNode<T>(key);
                break;
            } else {
                q.add(node.right);
            }
        }
    }

    @Override
    public void delete(T key) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            } else {
                return;
            }
        }

        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);
        TreeNode<T> keyNode = null;
        TreeNode<T> node = null;

        while (!q.isEmpty()) {
            node = q.poll();

            if (node.key == key)
                keyNode = node;

            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);
        }

        if (keyNode != null) {
            T x = node.key;
            deleteDeepest(node);
            keyNode.key = x;
        }
    }

    void deleteDeepest(TreeNode delNode) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode<T> node = null;

        while (!q.isEmpty()) {
            node = q.poll();

            if (node == delNode) {
                node = null;
                return;
            }
            if (node.right != null) {
                if (node.right == delNode) {
                    node.right = null;
                    return;
                } else
                    q.add(node.right);
            }

            if (node.left != null) {
                if (node.left == delNode) {
                    node.left = null;
                    return;
                } else
                    q.add(node.left);
            }
        }
    }

    @Override
    public TreeNode<T> getRoot() {
        return root;
    }
}
