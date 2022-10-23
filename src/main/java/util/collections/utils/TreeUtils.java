package util.collections.utils;

import util.collections.interfaces.tree.TreeI;
import util.collections.interfaces.tree.TreeNodeI;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TreeUtils {

    //later I'll replace the list with my dymanic array
    //list should guarantee the order
    //need some OrderedList
    public static <T> void printInOrderTraversal(TreeI<T> tree) {
        ArrayList<T> tList = new ArrayList<>();
        inOrderTraversal(tree.getRoot(), tList);
        List<String> nodes = tList.stream().filter(Objects::nonNull).map(o -> o.toString()).collect(Collectors.toList());
        System.out.println(String.join(" ", nodes));
    }

    public static <T> T[] inOrderTraversalToArray(TreeI<T> tree, Class tClass) {
        ArrayList<T> tList = new ArrayList<>();
        inOrderTraversal(tree.getRoot(), tList);
        T[] arr = (T[]) Array.newInstance(tClass, tList.size());
        return tList.toArray(arr);
    }

    public static <T> void inOrderTraversal(TreeNodeI<T> root, ArrayList<T> tList) {
        if (root == null)
            return;

        inOrderTraversal(root.left(), tList);

        tList.add(root.key());

        inOrderTraversal(root.right(), tList);
    }

    public static <T> void printPreOrderTraversal(TreeI<T> tree) {
        ArrayList<T> tList = new ArrayList<>();
        preOrderTraversal(tree.getRoot(), tList);
        List<String> nodes = tList.stream().map(o -> o.toString()).collect(Collectors.toList());
        System.out.println(String.join(" ", nodes));
    }

    public static <T> void preOrderTraversal(TreeNodeI<T> root, ArrayList<T> tList) {
        if (root == null)
            return;

        tList.add(root.key());

        preOrderTraversal(root.left(), tList);

        preOrderTraversal(root.right(), tList);
    }

    public static <T> void printPostOrderTraversal(TreeI<T> tree) {
        ArrayList<T> tList = new ArrayList<>();
        postOrderTraversal(tree.getRoot(), tList);
        List<String> nodes = tList.stream().map(o -> o.toString()).collect(Collectors.toList());
        System.out.println(String.join(" ", nodes));
    }


    public static <T> void postOrderTraversal(TreeNodeI<T> root, ArrayList<T> tList) {
        if (root == null)
            return;

        postOrderTraversal(root.left(), tList);

        postOrderTraversal(root.right(), tList);

        tList.add(root.key());
    }

    public static <T> List<List<T>> levelOrder(TreeNodeI<T> root) {
        List<List<T>> l = new ArrayList<>();
        if (root == null){
            return l;
        }

        List<T> lst1 = new ArrayList<>();
        lst1.add(root.key());
        l.add(lst1);

        Deque<TreeNodeI<T>> dq = new ArrayDeque<>();
        dq.addFirst(root);
        while(!dq.isEmpty()){
            int length = dq.size();
            List<T> lst = new ArrayList<>();
            for (int i = 0; i < length; i++){
                TreeNodeI<T> node = dq.pollFirst();
                if (node.left() != null) {
                    lst.add(node.left().key());
                    dq.addLast(node.left());
                }
                if (node.right() != null) {
                    lst.add(node.right().key());
                    dq.addLast(node.right());
                }
            }

            if (!lst.isEmpty()) l.add(lst);
        }
        return l;
    }
}
