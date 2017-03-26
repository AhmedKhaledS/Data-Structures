package trees.AVL;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class AVLNode<T extends Comparable<T>> implements INode<T> {

    /**
     * Reference to the left child of the current node.
     */
    public AVLNode leftChild;
    /**
     * Reference to the left child of the current node.
     */
    public AVLNode rightChild;
    private T value;
    /**
     * The height of the current node according to its tree.
     */
    public int height;

    /**
     * Default constructor of AVLNode.
     */
    public AVLNode() {
        value = null;
        this.leftChild = null;
        this.rightChild = null;
        height = 0;
    }

    public AVLNode(final T element, final AVLNode<T> leftChild, final
    AVLNode<T> rightChild) {
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
