package util.collections.implementations.trees;

public class AVLTree<T> extends BinarySearchTree<T> {

    private int height(TreeNode<T> node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private TreeNode<T> rightRotate(TreeNode<T> z) {
        TreeNode<T> y = z.left;
        TreeNode<T> T2 = y.right;

        y.right = z;
        z.left = T2;

        z.height = Math.max(height(z.left), height(z.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private TreeNode<T> leftRotate(TreeNode<T> z) {
        TreeNode<T> y = z.right;
        TreeNode<T> T2 = y.left;

        y.left = z;
        z.right = T2;

        z.height = Math.max(height(z.left), height(z.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(TreeNode<T> node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    private TreeNode<T> minValueNode(TreeNode<T> node) {
        TreeNode<T> current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }
    
    public void add(T key) {
        root = add(root, key);
    }

    private TreeNode<T> add(TreeNode<T> node, T key) {

        if (node == null)
            return new TreeNode(key);

        Comparable<T> nkey = (Comparable) node.key;
        if (nkey.compareTo(key) > 0) //key < node.val
            node.left = add(node.left, key);
        else if (nkey.compareTo(key) < 0) //key > node.val
            node.right = add(node.right, key);
        else // Duplicate keys not allowed
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
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
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right Left Case
        if (balance < -1 && node.right != null) {
            Comparable<T> nkeyRight = (Comparable) node.right.key;
            if (nkeyRight.compareTo(key) > 0) { //key < node.right.val
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    @Override
    public void remove(T key){
        root = removeNode(root, key);
    }

    public TreeNode<T> removeNode(TreeNode<T> node, T key) {

        if (node == null)
            return node;

        Comparable<T> nkey = (Comparable) node.key;
        if (nkey.compareTo(key) > 0)
            node.left = removeNode(node.left, key);
        else if (nkey.compareTo(key) < 0)
            node.right = removeNode(node.right, key);
        else {
            // node with only one child or no child
            if ((node.left == null) || (node.right == null)) {
                TreeNode<T> temp;
                if (node.left == null)
                    temp = node.right;
                else
                    temp = node.left;

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else // One child case
                    node = temp; // Copy the contents of the non-empty child
            } else {
                TreeNode<T> temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = removeNode(node.right, temp.key);
            }
        }

        if (node == null)
            return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

}
