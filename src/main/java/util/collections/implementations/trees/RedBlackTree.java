package util.collections.implementations.trees;

public class RedBlackTree<T> extends BinarySearchTree<T> {

    private final BlackNode<T> endNode = new BlackNode();

    public RedBlackTree() {}

    public void add(T key){
        TreeNode<T> newNode = new TreeNode<>(key, endNode, endNode);
        TreeNode<T> nodeParent = endNode;
        TreeNode<T> nodeToInsert = root;
        Comparable<T> newkey = (Comparable) newNode.key;
        while (nodeToInsert != endNode){
            nodeParent = nodeToInsert;
            if (newkey.compareTo(nodeToInsert.key) < 0)
                nodeToInsert = nodeToInsert.left;
            else nodeToInsert = nodeToInsert.right;
        }
        newNode.parent = nodeParent;
        if (nodeParent == endNode) {
            root = newNode;
        } else if (newkey.compareTo(newNode.key) < 0){
            nodeParent.left = newNode;
        } else {
            nodeParent.right = newNode;
        }
        newNode.color = 1;
        insertFixup(newNode);
    }

    private void insertFixup(TreeNode<T> node) {

    }
}
