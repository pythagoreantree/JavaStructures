package util.collections.implementations.trees;

import static util.collections.implementations.trees.RedBlackNode.BLACK;
import static util.collections.implementations.trees.RedBlackNode.RED;

public class RedBlackTree<T> extends BinarySearchTree<T> {

    private final BlackNode<T> endNode = new BlackNode();

    public RedBlackTree() {
    }

    /*
     * O(h), h <= 2log(n+1)
     * */
    public void add(T key) {
        RedBlackNode<T> newNode = new RedBlackNode<>(key, endNode, endNode);
        RedBlackNode<T> nodeParent = endNode;
        RedBlackNode<T> nodeToInsert = getRoot();
        Comparable<T> newkey = (Comparable) newNode.key();
        while (nodeToInsert != endNode) {
            nodeParent = nodeToInsert;
            if (newkey.compareTo(nodeToInsert.key()) < 0)
                nodeToInsert = nodeToInsert.left();
            else
                nodeToInsert = nodeToInsert.right();
        }
        newNode.setParent(nodeParent);
        if (nodeParent == endNode) {
            root = newNode;
            return;
        } else if (newkey.compareTo(newNode.key()) < 0) {
            nodeParent.setLeft(newNode);
        } else {
            nodeParent.setRight(newNode);
        }
        newNode.setColor(RED);
        insertFixup(newNode);
    }

    private void insertFixup(RedBlackNode<T> node) {
        //what if parent is black?
        if (node == null)
            throw new NullPointerException("Input Node is null.");
        //what if node == endNode
        RedBlackNode<T> parent = node.parent();
        if (parent == null)
            throw new NullPointerException("Parent node is null.");
        //what if parent == endNode

        while (parent.color() == RED) {
            //does GP exists?
            if (parent == parent.parent().left()) {
                RedBlackNode<T> uncle = parent.parent().right();
                //if uncle == null
                if (uncle == null || uncle.color() == BLACK) {
                    if (node == parent.right()) {
                        parent.parent().setLeft(leftRotate(parent));
                    }
                    swapColors(parent.parent().left(), parent.parent());
                    rightRotate(parent.parent());
                    break;
                } else if (uncle.color() == RED) {
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    parent.parent().setColor(RED);
                    node = node.parent().parent();
                }
            } else if (parent == parent.parent().right()) {
                RedBlackNode<T> uncle = parent.parent().left();
                //if uncle == null
                if (uncle == null || uncle.color() == BLACK) {
                    if (node == parent.left()) {
                        parent.parent().setRight(rightRotate(parent));
                    }
                    swapColors(parent.parent(), parent.parent().right());
                    leftRotate(parent.parent());
                    break;
                } else if (uncle.color() == RED) {
                    //incapsulate this part into function
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    parent.parent().setColor(RED);
                    node = node.parent().parent();
                }
            } else {
                throw new RuntimeException("Smth wrong with P - GP linkage.");
            }
        }
        getRoot().setColor(BLACK);
    }

    private void swapColors(RedBlackNode<T> node1, RedBlackNode<T> node2) {
        byte color = node1.color();
        node1.setColor(node2.color());
        node2.setColor(color);
    }

    private RedBlackNode<T> leftRotate(RedBlackNode<T> z) {
        RedBlackNode<T> y = z.right();
        RedBlackNode<T> T2 = y.left();

        y.setLeft(z);
        z.setRight(T2);

        return y;
    }

    private RedBlackNode<T> rightRotate(RedBlackNode<T> z) {
        RedBlackNode<T> y = z.left();
        RedBlackNode<T> T2 = y.right();

        y.setRight(z);
        z.setLeft(T2);

        return y;
    }

    @Override
    public void remove(T key) {
        RedBlackNode<T> nodeToDelete = (RedBlackNode<T>) search(key);
        remove(getRoot(), nodeToDelete);
    }

    public RedBlackNode<T> remove(RedBlackNode<T> node, RedBlackNode<T> keyNode) {
        RedBlackNode<T> y = keyNode;
        RedBlackNode<T> x = endNode;
        Byte yColor = y.color();
        if (keyNode.left() == endNode) {
            x = keyNode.right();
            redirect(keyNode, keyNode.right());
        } else if (keyNode.right() == endNode) {
            x = keyNode.left();
            redirect(keyNode, keyNode.left());
        } else {
            y = getMinimum(keyNode.right());
            yColor = y.color();
            x = y.right();
            if (y.parent() == keyNode) {
                x.setParent(y);
            } else {
                redirect(y, y.right());
                y.setRight(keyNode.right());
                y.right().setParent(y);
            }
            redirect(keyNode, y);
            y.setLeft(keyNode.left());
            y.left().setParent(y);
            y.setColor(keyNode.color());
        }
        if (yColor == BLACK) {
            removeFixup(x);
        }
        return node;
    }

    private RedBlackNode<T> getMinimum(RedBlackNode<T> node) {
        while (node != endNode) {
            node = node.left();
        }
        return node;
    }

    private void removeFixup(RedBlackNode<T> x) {
        while (x != getRoot() && x.color() == BLACK) {
            if (x == x.parent().left()) {
                RedBlackNode<T> w = x.parent().right();
                if (w.color() == RED) {
                    w.setColor(BLACK);
                    x.parent().setColor(RED);
                    leftRotate(x.parent());
                    w = x.parent().right();
                }
                //now w is black
                if (w.left().color() == BLACK && w.right().color() == BLACK) {
                    w.setColor(RED);
                    x = x.parent();
                } else if (w.right().color() == BLACK) {
                    w.left().setColor(BLACK);
                    w.setColor(RED);
                    rightRotate(w);
                    w = x.parent().right();
                }
                w.setColor(x.parent().color());
                x.parent().setColor(BLACK);
                w.right().setColor(BLACK);
                leftRotate(x.parent());
                x = getRoot();
            } else if (x == x.parent().right()) {
                RedBlackNode<T> w = x.parent().left();
                if (w.color() == RED) {
                    w.setColor(BLACK);
                    x.parent().setColor(RED);
                    rightRotate(x.parent());
                    w = x.parent().left();
                }
                if (w.left().color() == BLACK && w.right().color() == BLACK) {
                    w.setColor(RED);
                    x = x.parent();
                } else if (w.left().color() == BLACK) {
                    w.right().setColor(BLACK);
                    w.setColor(RED);
                    leftRotate(w);
                    w = x.parent().left();
                }
                w.setColor(x.parent().color());
                x.parent().setColor(BLACK);
                w.left().setColor(BLACK);
                rightRotate(x.parent());
                x = getRoot();
            }
        }
        x.setColor(BLACK);
    }

    private void redirect(RedBlackNode<T> u, RedBlackNode<T> v) {
        if (u.parent() == endNode) {
            setRoot(v);
            return;
        }
        if (u == u.parent().left()) {
            u.parent().setLeft(v);
        } else if (u == u.parent().right()) {
            u.parent().setRight(v);
        }
        v.setParent(u.parent());
        u.setParent(endNode);
    }

    public void setRoot(RedBlackNode<T> v) {
        this.root = v;
    }

    @Override
    public RedBlackNode<T> getRoot() {
        return (RedBlackNode<T>) super.getRoot();
    }
}
