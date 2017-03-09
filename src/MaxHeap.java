import exceptions.HeapIsEmptyException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class MaxHeap<T extends Comparable<T>> {

    private List<T> heap;
    private int size;

    public MaxHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    public MaxHeap(T[] array) {
        heap = new ArrayList<>(Arrays.asList(array));
        size = array.length;
        buildMaxHeap();
    }

    public MaxHeap(Collection<T> array) {
        heap = new ArrayList<>(array);
        buildMaxHeap();
    }

    public void maxHeapInsert(T element) {
        size++;
    }

    public T[] getAsArray() {

        return null;
    }

    public Collection<T> getAsCollection() {
        return heap;
    }

    private void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest;
        if (left < size && heap.get(left).compareTo(heap.get(i)) > 0 ) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0 ) {
            largest = right;
        }
        if (largest != i) {
            Collections.swap(heap, i, largest);
            maxHeapify(largest);
        }
    }

    private void buildMaxHeap() {
        for (int position = size/2 - 1; position >= 0; position--) {
            maxHeapify(position);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T extractMax() throws HeapIsEmptyException {
        if (size < 1)
            throw new HeapIsEmptyException("Heap is empty.");
        size--;
        T maxElement = heap.get(0);
        heap.set(0, heap.get(size - 1));
        maxHeapify(0);
        return maxElement;
    }

    public void insert(T element) {

    }

    public void heapSort() {
        for (int i = size - 1; i >= 1; i--) {
            Collections.swap(heap, i, 0);
            size--;
            maxHeapify(0);
        }
    }

    private int parent(int i) {
        return (i - 1)/2;
    }

    private int left(int i) {
        return i*2 + 1;
    }

    private int right(int i) {
        return i*2 + 2;
    }

    private boolean hasLeft(int i) {
        return i*2 + 1 < size;
    }

    private boolean hasRight(int i) {
        return i*2 + 2 < size;
    }
}