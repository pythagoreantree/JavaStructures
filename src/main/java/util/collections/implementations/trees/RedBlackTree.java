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
        RedBlackNode<T> keyNode = new RedBlackNode<>(key, endNode, endNode);
        add(keyNode);
    }

    private void add(RedBlackNode<T> redBlackNode){
        RedBlackNode<T> nodeParent = endNode;
        RedBlackNode<T> nodeToInsert = getRoot();
        Comparable<T> newkey = (Comparable) redBlackNode.key();
        while (nodeToInsert != endNode) {
            nodeParent = nodeToInsert;
            if (newkey.compareTo(nodeToInsert.key()) < 0)
                nodeToInsert = nodeToInsert.left();
            else
                nodeToInsert = nodeToInsert.right();
        }
        redBlackNode.setParent(nodeParent);
        if (getRoot() == endNode) {
            setRoot(redBlackNode);
            return;
        } else if (newkey.compareTo(redBlackNode.key()) < 0) {
            nodeParent.setLeft(redBlackNode);
        } else {
            nodeParent.setRight(redBlackNode);
        }
        redBlackNode.setColor(RED);
        insertFixup(redBlackNode);
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
            RedBlackNode<T> grandParent = parent.parent();
            if (parent == grandParent.left()) {
                RedBlackNode<T> uncle = grandParent.right();
                //if uncle == null
                if (uncle == endNode || uncle.color() == BLACK) {
                    if (node == parent.right()) {
                        grandParent.setLeft(leftRotate(parent));
                    }
                    swapColors(grandParent, parent);
                    rightRotate(grandParent);
                    break;
                } else if (uncle.color() == RED) {
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    parent.parent().setColor(RED);
                    node = node.parent().parent();
                }
            } else if (parent == grandParent.right()) {
                RedBlackNode<T> uncle = grandParent.left();
                //if uncle == null
                if (uncle == endNode || uncle.color() == BLACK) {
                    if (node == parent.left()) {
                        grandParent.setRight(rightRotate(parent));
                    }
                    swapColors(grandParent, parent);
                    leftRotate(grandParent);
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

    /*private void rotateAndAssign(RedBlackNode<T> grandParent, boolean isLeft){
        RedBlackNode<T> ggParent = grandParent.parent();
        Integer flag = 0;
        if (grandParent == ggParent.left()) {
            flag = 1;
        } else if (grandParent == ggParent.right()) {
            flag = 2;
        }
        RedBlackNode<T> rNode = isLeft? leftRotate(grandParent): rightRotate(ggParent);
        switch(flag){
            case 0:
                setRoot(rNode);
                break;
            case 1:
                ggParent.setLeft(rNode);
                break;
            case 2:
                ggParent.setRight(rNode);
                break;
            default:
                throw new RuntimeException("strange flag " + flag);
        }
    }*/

    private RedBlackNode<T> leftRotate(RedBlackNode<T> z) {
        RedBlackNode<T> parent = z.parent();
        int flag = 0;
        if (z == parent.left()){
            flag = 1;
            parent.setLeft(endNode);
        } else if (z == parent.right()){
            flag = 2;
            parent.setRight(endNode);
        }

        RedBlackNode<T> y = z.right();
        RedBlackNode<T> leftTree = y.left();

        y.setLeft(z);
        z.setParent(y);

        z.setRight(leftTree);
        leftTree.setParent(z);

        switch (flag){
            case 0:
                setRoot(y);
                break;
            case 1:
                parent.setLeft(y);
                break;
            case 2:
                parent.setRight(y);
                break;
            default:
                throw new RuntimeException("No such case!");
        }

        return y;
    }

    private RedBlackNode<T> rightRotate(RedBlackNode<T> z) {
        RedBlackNode<T> parent = z.parent();
        int flag = 0;
        if (z == parent.left()){
            flag = 1;
            parent.setLeft(endNode);
        } else if (z == parent.right()){
            flag = 2;
            parent.setRight(endNode);
        }

        RedBlackNode<T> y = z.left();
        RedBlackNode<T> rightTree = y.right();

        y.setRight(z);
        z.setParent(y);

        z.setLeft(rightTree);
        rightTree.setParent(z);

        switch (flag){
            case 0:
                setRoot(y);
                break;
            case 1:
                parent.setLeft(y);
                break;
            case 2:
                parent.setRight(y);
                break;
            default:
                throw new RuntimeException("No such case!");
        }

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
                } else {
                    if (w.right().color() == BLACK) {
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
                }
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
                } else {
                    if (w.left().color() == BLACK) {
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
        RedBlackNode r = (RedBlackNode<T>) super.getRoot();
        return r != null? r: endNode;
    }
}
