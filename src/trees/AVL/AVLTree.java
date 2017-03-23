package trees.AVL;

import java.rmi.MarshalException;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class AVLTree<T extends Comparable<T>> implements IAVLTree<T> {

    private final int MAX_BALANCE_FACTOR = 1;
    AVLNode<T> root;
    @Override
    public void insert(T key) {
        if (key == null) return;
        redirect(key, root);
    }

    private AVLNode<T> redirect(T key, AVLNode<T> current) {
        if (current == null) {
            return new AVLNode<T>(key, null, null);
        }
        int compare = key.compareTo(current.getValue());
        if (compare < 0) {
            current.leftChild = redirect(key, current.leftChild);
        } else if (compare > 0 ) {
            current.leftChild = redirect(key, current.leftChild);
        }
        return rebalance(current);
    }

    private AVLNode<T> rebalance(AVLNode<T> node) {
        if (node == null) return node;
        if (node.leftChild.height - node.rightChild.height
                > MAX_BALANCE_FACTOR) {
            if (node.leftChild.leftChild.height >=  node.leftChild
                    .rightChild.height) {
                node = leftRotation(node);
            } else {
                node = leftRightRotation(node);
            }
        } else if (node.rightChild.height - node.leftChild.height
                > MAX_BALANCE_FACTOR) {
            if (node.rightChild.rightChild.height >=  node.rightChild
                    .leftChild.height) {
                node = rightRotation(node);
            } else {
                node = rightLeftRotation(node);
            }
        }
        node.height = Math.max(node.leftChild.height, node.rightChild.height)
                + 1;
        return node;
    }

    private AVLNode<T> leftRotation(AVLNode<T> node) {
        AVLNode<T> left = node.leftChild;
        node.leftChild = left.rightChild;
        left.rightChild = node;
        node.height = Math.max(node.leftChild.height, node.rightChild.height)
                + 1;
        left.height = Math.max(left.leftChild.height, left.rightChild.height)
                + 1;
        return left;
    }

    private AVLNode<T> rightRotation(AVLNode<T> node) {
        AVLNode<T> right = node.rightChild;
        node.rightChild = right.leftChild;
        right.leftChild = node;
        node.height = Math.max(node.leftChild.height, node.rightChild.height)
                + 1;
        right.height = Math.max(right.leftChild.height, right.rightChild.height)
                + 1;
        return right;
    }

    private AVLNode<T> leftRightRotation(AVLNode<T> node) {
        node.leftChild = rightRotation(node.leftChild);
        return leftRotation(node);
    }

    private AVLNode<T> rightLeftRotation(AVLNode<T> node) {
        node.rightChild = leftRotation(node.rightChild);
        return rightRotation(node);
    }
    @Override
    public boolean delete(T key) {
        return false;
    }

    @Override
    public boolean search(T key) {
        return false;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public INode<T> getTree() {
        return null;
    }
}
