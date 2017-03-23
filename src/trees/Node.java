package trees;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class Node<T extends Comparable<T>> implements INode<T> {

    private Node leftChild;
    private Node rightChild;
    private T value;

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
