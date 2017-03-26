package trees.AVL;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class AVLTree<T extends Comparable<T>> implements IAVLTree<T> {

    private final int MAX_BALANCE_FACTOR = 1;
    private AVLNode<T> root;

    /**
     * Default constructor.
     */
    public AVLTree() {
        root = new AVLNode<T>();
    }

    /**
     * Overriden constructor which have parameter the key of the tree root.
     * @param key the value of the root node of the AVL tree.
     */
    public AVLTree(final T key) {
        root = new AVLNode<T>(key, null, null);
        root.height = 0;
    }

    @Override
    public void insert(final T key) {
        if (key == null) return;
        root = insert(key, root);
    }



    /**
     * Insert the given value using the key.
     * @param key the value to be inserted in the tree.
     * @param current the current root of the given subtree.
     * @return {@link AVLNode} returns the root of the given subtree.
     */
    private AVLNode<T> insert(final T key, final AVLNode<T> current) {
        if (current == null || current.getValue() == null) {
            return new AVLNode<T>(key, null, null);
        }
        int compare = key.compareTo(current.getValue());
        if (compare < 0) {
            current.leftChild = insert(key, current.leftChild);
        } else if (compare > 0 ) {
            current.rightChild = insert(key, current.rightChild);
        }
        return rebalance(current);
    }

    /**
     * Balances the given subtree if the balance factor exceeds the maximum
     * desired value.
     * @param node {@link AVLNode}the root of the the given subtree to balance.
     * @return {@link AVLNode} returns the new root after balancing the given
     * subtree.
     */
    private AVLNode<T> rebalance(AVLNode<T> node) {
        if (node == null) return node;
        // Checks if there exists violation in AVL properties.
        if (height(node.leftChild) - height(node.rightChild)
                > MAX_BALANCE_FACTOR) {
            if (height(node.leftChild.leftChild) >=  height(node.leftChild
                    .rightChild)) {
                node = leftRotation(node);
            } else {
                node = leftRightRotation(node);
            }
        } else if (height(node.rightChild) - height(node.leftChild)
                > MAX_BALANCE_FACTOR) {
            if (height(node.rightChild.rightChild) >=  height(node.rightChild
                    .leftChild)) {
                node = rightRotation(node);
            } else {
                node = rightLeftRotation(node);
            }
        }
        node.height = Math.max(height(node.leftChild), height(node.rightChild))
                + 1;
        return node;
    }

    /**
     * Balances the given subtree using left rotation technique.
     * @param node {@link AVLNode} the given node of subtree required to be
     * rebalanced.
     * @return {@link AVLNode} returns the new root of the given subtree
     * after balancing (rotation).
     */
    private AVLNode<T> leftRotation(final AVLNode<T> node) {
        AVLNode<T> left = node.leftChild;
        node.leftChild = left.rightChild;
        left.rightChild = node;
        node.height = Math.max(height(node.leftChild), height(node.rightChild))
                + 1;
        left.height = Math.max(height(left.leftChild), height(left.rightChild))
                + 1;
        return left;
    }

    /**
     * Balances the given subtree using right rotation technique.
     * @param node {@link AVLNode} the given node of subtree required to be
     * rebalanced.
     * @return {@link AVLNode} returns the new root of the given subtree
     * after balancing (rotation).
     */
    private AVLNode<T> rightRotation(final AVLNode<T> node) {
        AVLNode<T> right = node.rightChild;
        node.rightChild = right.leftChild;
        right.leftChild = node;
        node.height = Math.max(height(node.leftChild), height(node.rightChild))
                + 1;
        right.height = Math.max(height(right.leftChild), height(right.rightChild))
                + 1;
        return right;
    }

    /**
     * Performs balance to the given subtree after double rotation technique
     * (left then right rotations).
     * @param node {@link AVLNode} the given node of subtree required to be
     * rebalanced.
     * @return {@link AVLNode} returns the new root of the given subtree
     * after balancing (rotation).
     */
    private AVLNode<T> leftRightRotation(final AVLNode<T> node) {
        node.leftChild = rightRotation(node.leftChild);
        return leftRotation(node);
    }

    /**
     * Performs balance to the given subtree after double rotation technique
     * (right then left rotations).
     * @param node {@link AVLNode} the given node of subtree required to be
     * rebalanced.
     * @return {@link AVLNode} returns the new root of the given subtree
     * after balancing (rotation).
     */
    private AVLNode<T> rightLeftRotation(final AVLNode<T> node) {
        node.rightChild = leftRotation(node.rightChild);
        return rightRotation(node);
    }

    /**
     * Computes the height of the given node in the tree.
     * @param node {@link AVLNode} the given node to compute the height.
     * @return returns the height of the given node in the tree.
     */
    private int height(AVLNode<T> node) {
        if (node == null) {
            return -1;
        }
        return  node.height;
    }
    @Override
    public boolean delete(T key) {
        if (!search(key)) {
            return false;
        }
        root = delete(key, root);
        return true;
    }

    /**
     * Delete the key (if exists).
     * @param key the key of the node.
     * @param node {@link AVLNode} the current root of the given subtree.
     * @return {@link AVLNode} true if node deleted, false if not exists.
     */
    private AVLNode<T> delete(final T key, AVLNode<T> node) {
        if (node == null) {
            return node;
        }
        int compare = key.compareTo(node.getValue());
        if (compare < 0) {
            node.leftChild = delete(key, node.leftChild);
        } else if (compare > 0) {
            node.rightChild = delete(key, node.rightChild);
        } else if (node.leftChild != null && node.rightChild != null) {
            node.setValue((T) findMinNode(node.rightChild).getValue());
            node.rightChild = delete(node.getValue(), node.rightChild);
        } else {
            // Root element.
            // Handles also the deletion of the predecessor element after
            // copying its value.
            // The predecessor is found as the minimum element in the right
            // subtree of the desired node to be deleted.
            if (node.leftChild != null) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return rebalance(node);
    }

    /**
     * Finds the minimum node in the right subtree (predecessor).
     * @param node root of the subtree.
     * @return returns the predecessor node.
     */
    private AVLNode<T> findMinNode(final AVLNode<T> node) {
        if (node.leftChild == null) {
            return node;
        }
        return findMinNode(node.leftChild);
    }

    @Override
    public boolean search(T key) {
        return search(key, root);
    }

    /**
     * Search for a specific element using the key in the tree.
     * @param key the key of the node.
     * @param node {@link AVLNode} The current root of the given subtree.
     * @return true if the key exists, false otherwise.
     */
    private boolean search(T key, AVLNode<T> node) {
        if (node == null || node.getValue() == null) return false;
        if (node.getValue().equals(key)) return true;
        if (key.compareTo(node.getValue()) < 0) {
            return search(key, node.leftChild);
        } else {
            return search(key, node.rightChild);
        }
    }

    @Override
    public int height() {
        return root.height;
    }

    @Override
    public INode<T> getTree() {
        return root;
    }
}
