package trees.AVL;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class AVLNode<T extends Comparable<T>> implements INode<T> {

    public AVLNode leftChild;
    public AVLNode rightChild;
    private T value;
    public int height;

    public AVLNode() {
        value = null;
        this.leftChild = null;
        this.rightChild = null;
        height = 0;
    }

    public AVLNode(T element, AVLNode<T> leftChild, AVLNode<T> rightChild) {
        value = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        height = 0;
    }

    @Override
    public INode<T> getLeftChild() {
        return leftChild;
    }

    @Override
    public INode<T> getRightChild() {
        return rightChild;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
