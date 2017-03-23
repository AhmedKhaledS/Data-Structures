package trees;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class AVLTree<T extends Comparable<T>> implements IAVLTree<T> {
    @Override
    public void insert(T key) {

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
