package util.collections.implementations.trees;

import util.collections.interfaces.tree.TreeI;

public class AVLTree<T> implements TreeI<T> {

    public AVLNode<T> root;

    // A utility function to get the height of a node
    private int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    private AVLNode rightRotate(AVLNode z) {
        AVLNode y = (AVLNode) z.left;
        AVLNode T2 = (AVLNode) y.right;

        // Perform rotation
        y.right = z;
        z.left = T2;

        // Update heights
        z.height = Math.max(height((AVLNode) z.left), height((AVLNode) z.right)) + 1;
        y.height = Math.max(height((AVLNode) y.left), height((AVLNode) y.right)) + 1;

        // Return new root
        return y;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    private AVLNode leftRotate(AVLNode z) {
        AVLNode y = (AVLNode) z.right;
        AVLNode T2 = (AVLNode) y.left;

        // Perform rotation
        y.left = z;
        z.right = T2;

        //  Update heights
        z.height = Math.max(height((AVLNode) z.left), height((AVLNode) z.right)) + 1;
        y.height = Math.max(height((AVLNode) y.left), height((AVLNode) y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of a node
    private int getBalance(AVLNode node) {
        if (node == null)
            return 0;

        return height((AVLNode) node.left) - height((AVLNode) node.right);
    }

    @Override
    public TreeNode<T> search(T key) {
        return root;
    }

    @Override
    public void remove(T key) {

    }

    @Override
    public TreeNode<T> getRoot() {
        return root;
    }

    public void add(T key) {
        root = add(root, key);
    }

    public AVLNode<T> add(AVLNode<T> node, T key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new AVLNode(key));

        Comparable<T> nkey = (Comparable) node.key;
        if (nkey.compareTo(key) > 0) //key < node.val
            node.left = add((AVLNode<T>) node.left, key);
        else if (nkey.compareTo(key) < 0) //key > node.val
            node.right = add((AVLNode<T>) node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + Math.max(height((AVLNode) node.left), height((AVLNode) node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        //here it may fail if node.left == null
        if (balance > 1 && node.left != null) {
            Comparable<T> nkeyLeft = (Comparable) node.left.key;
            if (nkeyLeft.compareTo(key) > 0) { //key < node.left.val
                return rightRotate(node);
            }
        }

        // Right Right Case
        if (balance < -1 && node.right != null) { //key > node.right.val
            Comparable<T> nkeyRight = (Comparable) node.right.key;
            if (nkeyRight.compareTo(key) < 0)
                return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && node.left != null) {
            Comparable<T> nkeyLeft = (Comparable) node.left.key;
            if (nkeyLeft.compareTo(key) < 0) { //key > node.left.val
                node.left = leftRotate((AVLNode) node.left);
                return rightRotate(node);
            }
        }

        // Right Left Case
        if (balance < -1 && node.right != null) {
            Comparable<T> nkeyRight = (Comparable) node.right.key;
            if (nkeyRight.compareTo(key) > 0) { //key < node.right.val
                node.right = rightRotate((AVLNode) node.right);
                return leftRotate(node);
            }
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void inOrderTraversal(AVLNode root) {
        if (root == null)
            return;

        inOrderTraversal((AVLNode) root.left);

        System.out.print(root.key + " ");

        inOrderTraversal((AVLNode) root.right);
    }
}
