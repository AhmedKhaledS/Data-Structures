package trees.AVL;

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
        return null;
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
