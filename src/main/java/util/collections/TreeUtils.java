package util.collections;

import util.collections.implementations.trees.TreeNode;
import util.collections.interfaces.tree.TreeI;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeUtils {

    public static <T> void inOrderTraversal(TreeI<T> tree) {
        inOrderTraversal(tree.getRoot());
    }

    public static <T> void inOrderTraversal(TreeNode<T> root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        System.out.println(root.key);

        inOrderTraversal(root.right);
    }

    public static <T> void preOrderTraversal(TreeI<T> tree) {
       preOrderTraversal(tree.getRoot());
    }

    public static <T> void preOrderTraversal(TreeNode<T> root) {
        if (root == null)
            return;

        System.out.println(root.key);

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);
    }

    public static <T> void postOrderTraversal(TreeI<T> tree) {
        preOrderTraversal(tree.getRoot());
    }


    public static <T> void postOrderTraversal(TreeNode<T> root) {
        if (root == null)
            return;

        System.out.println(root.key);

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);
    }

    public static <T> List<List<T>> levelOrder(TreeNode<T> root) {
        List<List<T>> l = new ArrayList<>();
        if (root == null){
            return l;
        }

        List<T> lst1 = new ArrayList<>();
        lst1.add(root.key);
        l.add(lst1);

        Deque<TreeNode<T>> dq = new ArrayDeque<>();
        dq.addFirst(root);
        while(!dq.isEmpty()){
            int length = dq.size();
            List<T> lst = new ArrayList<>();
            for (int i = 0; i < length; i++){
                TreeNode<T> node = dq.pollFirst();
                if (node.left != null) {
                    lst.add(node.left.key);
                    dq.addLast(node.left);
                }
                if (node.right != null) {
                    lst.add(node.right.key);
                    dq.addLast(node.right);
                }
            }

            if (!lst.isEmpty()) l.add(lst);
        }
        return l;
    }
}
