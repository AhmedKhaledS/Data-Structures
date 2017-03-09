import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class MaxBinaryHeap {
    private ArrayList<?> heap;
    private int size;

    public MaxBinaryHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    public MaxBinaryHeap(Object[] array) {
        heap = new ArrayList<>(Arrays.asList(array));
        size = array.length;
    }

    public MaxBinaryHeap(List<? extends Object> array) {
        heap = new ArrayList<>(array);
        size = array.size();
    }

    public MaxBinaryHeap(Collection<? extends Object> array) {
        heap = new ArrayList<>(Arrays.asList(array));
    }

    public void maxHeapInsert(Object element) {
        size++;
    }

    private void maxHeapify() {

    }

    private void buildMaxHeap() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object extractMax() {
        if (size <= 0)
            return null;
        size--;
        return null;
    }

    public void heapSort() {

    }

    private int parent(int i) {
        return i / 2;
    }

    private Object leftChild(int i) {
        return heap.get(i * 2);
    }

    private Object rightChild(int i) {
        return heap.get(i * 2 + 1);
    }

    private boolean hasLeftChild(int i) {
        return i * 2 < size;
    }

    private boolean hasRightChild(int i) {
        return i * 2 + 1 < size;
    }
}
