package util.collections.implementations.trees;

public class SplayTree<T> extends BinarySearchTree<T> {

    @Override
    public TreeNode<T> search(T key) {
        return search(root, key);
    }

    private TreeNode<T> rightRotate(TreeNode<T> z) {
        TreeNode<T> y = z.left();
        z.setLeft(y.right());
        y.setRight(z);
        return y;
    }

    // A utility function to left rotate subtree rooted with z
    private TreeNode<T> leftRotate(TreeNode<T> z) {
        TreeNode<T> y = z.right();
        z.setRight(y.left());
        y.setLeft(z);
        return y;
    }

    private TreeNode<T> search(TreeNode<T> root, T key) {

        if (root == null || root.key() == key)
            return root;

        Comparable<T> rootKey = (Comparable) root.key();
        if (rootKey.compareTo(key) > 0) {

            if (root.left() == null) return root;

            // Zig-Zig (Left Left)
            Comparable<T> rootLeftKey = (Comparable) root.left().key();
            if (rootLeftKey.compareTo(key) > 0) {
                root.left().setLeft(search(root.left().left(), key));
                root = rightRotate(root);
            } else if (rootLeftKey.compareTo(key) < 0) /* Zig-Zag (Left Right)*/  {
                root.left().setRight(search(root.left().right(), key));
                if (root.left().right() != null)
                    root.setLeft(leftRotate(root.left()));
            }

            return (root.left() == null) ? root : rightRotate(root);

        } else /* Key lies in right subtree*/ {
            if (root.right() == null) return root;

            // Zag-Zig (Right Left)
            Comparable<T> rootRightKey = (Comparable) root.right().key();
            if (rootRightKey.compareTo(key) > 0) {
                root.right().setLeft(search(root.right().left(), key));
                if (root.right().left() != null)
                    root.setRight(rightRotate(root.right()));
            } else if (rootRightKey.compareTo(key) < 0)/* Zag-Zag (Right Right)*/ {
                root.right().setRight(search(root.right().right(), key));
                root = leftRotate(root);
            }

            return (root.right() == null) ? root : leftRotate(root);
        }
    }

    @Override
    public void add(T key){
        root = add(root, key);
    }

    private TreeNode<T> add(TreeNode<T> root, T key) {
        if (root == null) return new TreeNode<T>(key);

        root = search(root, key);

        if (root.key() == key) return root;

        TreeNode<T> newNode = new TreeNode<T>(key);
        Comparable<T> rootKey = (Comparable) root.key();
        if (rootKey.compareTo(key) > 0) {
            newNode.setRight(root);
            newNode.setLeft(root.left());
            root.setLeft(null);
        } else {
            newNode.setLeft(root);
            newNode.setRight(root.right());
            root.setRight(null);
        }
        return newNode;
    }

    @Override
    public void remove(T key) {
        root = remove(root, key);
    }

    @Override
    public TreeNode<T> remove(TreeNode<T> root, T key) {

        if (root == null)
            return null;

        // Splay the given key
        root = search(root, key);

        // If key is not present, then
        // return root
        Comparable<T> rootKey = (Comparable) root.key();
        if (rootKey == null && key == null)
            return root;
        if (rootKey.compareTo(key) != 0)
            return root;

        // If key is present
        // If left child of root does not exist
        // make root.right as root
        if (root.left() == null)
            return root.right();

        // Else if left child exits
        TreeNode<T> temp = root;
        /*Note: Since key == root.key,
        so after Splay(key, root.lchild),
        the tree we get will have no right child tree
        and maximum node in left subtree will get splayed*/
        // New root
        root = search(root.left(), key);

        // Make right child of previous root as
        // new root's right child
        root.setRight(temp.right());

        // return root of the new Splay Tree
        return root;
    }
}
