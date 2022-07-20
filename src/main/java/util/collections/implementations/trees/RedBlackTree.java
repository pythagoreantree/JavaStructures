package util.collections.implementations.trees;

public class RedBlackTree<T> extends BinarySearchTree<T> {

    private final BlackNode<T> endNode = new BlackNode();

    public RedBlackTree() {}

    /*
    * O(h), h <= 2log(n+1)
    * */
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
            return;
        } else if (newkey.compareTo(newNode.key) < 0){
            nodeParent.left = newNode;
        } else {
            nodeParent.right = newNode;
        }
        newNode.color = 1;
        insertFixup(newNode);
    }

    private void insertFixup(TreeNode<T> node) {
        //what if parent is black?
        if (node == null)
            throw new NullPointerException("Input Node is null.");
        //what if node == endNode
        TreeNode<T> parent = node.parent;
        if (parent == null)
            throw new NullPointerException("Parent node is null.");
        //what if parent == endNode

        while (parent.color == 1) {
            //does GP exists?
            if (parent == parent.parent.left){
                TreeNode<T> uncle = parent.parent.right;
                //if uncle == null
                if (uncle == null || uncle.color == 0) {
                    if (node == parent.right){
                        parent.parent.left = leftRotate(parent);
                    }
                    swapColors(parent.parent.left, parent.parent);
                    rightRotate(parent.parent);
                    break;
                } else if (uncle.color == 1) {
                    parent.color = 0;
                    uncle.color = 0;
                    parent.parent.color = 1;
                    node = node.parent.parent;
                }
            } else if (parent == parent.parent.right){
                TreeNode<T> uncle = parent.parent.left;
                //if uncle == null
                if (uncle == null || uncle.color == 0) {
                    if (node == parent.left){
                        parent.parent.right = rightRotate(parent);
                    }
                    swapColors(parent.parent, parent.parent.right);
                    leftRotate(parent.parent);
                    break;
                } else if (uncle.color == 1){
                    //incapsulate this part into function
                    parent.color = 0;
                    uncle.color = 0;
                    parent.parent.color = 1;
                    node = node.parent.parent;
                }
            } else {
                throw new RuntimeException("Smth wrong with P - GP linkage.");
            }
        }
        root.color = 0;
    }

    private void swapColors(TreeNode<T> node1, TreeNode<T> node2) {
        byte color = node1.color;
        node1.color = node2.color;
        node2.color = color;
    }

    private TreeNode<T> leftRotate(TreeNode<T> z) {
        TreeNode<T> y = z.right;
        TreeNode<T> T2 = y.left;

        y.left = z;
        z.right = T2;

        return y;
    }

    private TreeNode<T> rightRotate(TreeNode<T> z) {
        TreeNode<T> y = z.left;
        TreeNode<T> T2 = y.right;

        y.right = z;
        z.left = T2;

        return y;
    }
}
