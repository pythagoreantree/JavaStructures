package util.collections.implementations.tree;

public class AVLTree<T> extends BinarySearchTree<T> {

    private int height(AVLNode<T> node) {
        if (node == null)
            return 0;
        return node.height();
    }

    private AVLNode<T> rightRotate(AVLNode<T> z) {
        AVLNode<T> y = z.left();
        AVLNode<T> T2 = y.right();

        y.setRight(z);
        z.setLeft(T2);

        z.setHeight(Math.max(height(z.left()), height(z.right())) + 1);
        y.setHeight(Math.max(height(y.left()), height(y.right())) + 1);

        return y;
    }

    private AVLNode<T> leftRotate(AVLNode<T> z) {
        AVLNode<T> y = z.right();
        AVLNode<T> T2 = y.left();

        y.setLeft(z);
        z.setRight(T2);

        z.setHeight(Math.max(height(z.left()), height(z.right())) + 1);
        y.setHeight(Math.max(height(y.left()), height(y.right())) + 1);

        return y;
    }

    private int getBalance(AVLNode<T> node) {
        if (node == null)
            return 0;

        return height(node.left()) - height(node.right());
    }

    private AVLNode<T> minValueNode(AVLNode<T> node) {
        AVLNode<T> current = node;

        /* loop down to find the leftmost leaf */
        while (current.left() != null)
            current = current.left();

        return current;
    }

    @Override
    public AVLNode<T> getRoot() {
        return (AVLNode<T>) super.getRoot();
    }

    public void add(T key) {
        root = add(getRoot(), key);
    }

    private AVLNode<T> add(AVLNode<T> node, T key) {

        if (node == null)
            return new AVLNode(key);

        Comparable<T> nkey = (Comparable) node.key();
        if (nkey.compareTo(key) > 0) //key < node.val
            node.setLeft(add(node.left(), key));
        else if (nkey.compareTo(key) < 0) //key > node.val
            node.setRight(add(node.right(), key));
        else // Duplicate keys not allowed
            return node;

        node.setHeight(1 + Math.max(height(node.left()), height(node.right())));

        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && node.left() != null
                && ((Comparable) node.left().key()).compareTo(key) > 0) {
            return rightRotate(node);
        }

        // Right Right Case (+)
        if (balance < -1 && node.right() != null
                && ((Comparable) node.right().key()).compareTo(key) < 0) { //node.right.key < key
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && node.left() != null
                && ((Comparable) node.left().key()).compareTo(key) < 0) {
            node.setLeft(leftRotate(node.left()));
            return rightRotate(node);
        }

        // Right Left Case (+)
        if (balance < -1 && node.right() != null
                && ((Comparable) node.right().key()).compareTo(key) > 0) { //node.right.key > key
            node.setRight(rightRotate(node.right()));
            return leftRotate(node);
        }

        return node;
    }

    @Override
    public void remove(T key){
        root = removeNode(getRoot(), key);
    }

    public AVLNode<T> removeNode(AVLNode<T> node, T key) {

        if (node == null)
            return node;

        //I can return Comparable from key() or smth similar
        Comparable<T> nkey = (Comparable) node.key();
        if (nkey.compareTo(key) > 0)
            node.setLeft(removeNode(node.left(), key));
        else if (nkey.compareTo(key) < 0)
            node.setRight(removeNode(node.right(), key));
        else {
            // node with only one child or no child
            if ((node.left() == null) || (node.right() == null)) {
                AVLNode<T> temp;
                if (node.left() == null)
                    temp = node.right();
                else
                    temp = node.left();

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else // One child case
                    node = temp; // Copy the contents of the non-empty child
            } else {
                AVLNode<T> temp = minValueNode(node.right());
                node.setKey(temp.key());
                node.setRight(removeNode(node.right(), temp.key()));
            }
        }

        if (node == null)
            return node;


        node.setHeight(Math.max(height(node.left()), height(node.right())) + 1);

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left()) >= 0)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && getBalance(node.left()) < 0) {
            node.setLeft(leftRotate(node.left()));
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right()) <= 0)
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && getBalance(node.right()) > 0) {
            node.setRight(rightRotate(node.right()));
            return leftRotate(node);
        }

        return node;
    }

}
