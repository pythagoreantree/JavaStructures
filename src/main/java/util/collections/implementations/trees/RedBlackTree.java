package util.collections.implementations.trees;

public class RedBlackTree<T> extends BinarySearchTree<T> {

    private final BlackNode<T> endNode = new BlackNode();

    public RedBlackTree() {}

    public void insert(T key){
        TreeNode<T> z = new TreeNode<>(key);
        TreeNode<T> y = endNode;
        TreeNode<T> x = root;
        Comparable<T> zkey = (Comparable) z.key;
        while (x != endNode){
            y = x;
            if (zkey.compareTo(x.key) < 0)
                x = x.left;
            else x = x.right;
        }
        z.parent = y;
        if (y == endNode) {
            root = z;
        } else if (zkey.compareTo(y.key) < 0){
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = endNode;
        z.right = endNode;
        z.color = 1;
        insertFixup(z);
    }

    private void insertFixup(TreeNode<T> z) {

    }

    @Override
    public void add(T key) {
        root = add(root, key);
    }

    private TreeNode<T> add(TreeNode<T> node, T key){
        return null;
    }
}
