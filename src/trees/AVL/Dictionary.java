package trees.AVL;

import java.io.File;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class Dictionary implements IDictionary {

    private IAVLTree<String> tree;
    private int size;
    @Override
    public void load(File file) {
        size = 0;
        tree = new AVLTree<>();
    }

    @Override
    public boolean insert(String word) {
        if (exists(word)) {
            return false;
        }
        tree.insert(word);
        size++;
        return true;
    }

    @Override
    public boolean exists(String word) {
        if (tree.search(word)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String word) {
        if (tree.delete(word)) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int height() {
        return tree.height();
    }
}
