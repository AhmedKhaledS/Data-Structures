import exceptions.HeapIsEmptyException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class MinHeap<T extends Comparable<T>> {

    private List<T> heap;
    private int size;

    public MinHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    public MinHeap(T[] array) {
        heap = new ArrayList<>(Arrays.asList(array));
        size = array.length;
        buildMinHeap();
    }

    public MinHeap(Collection<T> array) {
        heap = new ArrayList<>(array);
        buildMinHeap();
    }

    public void minHeapInsert(T element) {
        size++;
    }

    public T[] getAsArray() {

        return null;
    }

    public Collection<T> getAsCollection() {
        return heap;
    }

    private void minHeapifyDown(int i) {
        int left = left(i);
        int right = right(i);
        int smallest;
        if (left < size && heap.get(left).compareTo(heap.get(i)) < 0) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            minHeapifyDown(smallest);
        }
    }

    private void buildMinHeap() {
        for (int position = size/2 - 1; position >= 0; position--) {
            minHeapifyDown(position);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T extractMin() throws HeapIsEmptyException {
        if (size < 1)
            throw new HeapIsEmptyException("Heap is empty.");
        size--;
        T maxElement = heap.get(0);
        heap.set(0, heap.get(size - 1));
        minHeapifyDown(0);
        return maxElement;
    }

    public void insert(T element) {
        heap.add(element);
        int index = size;
        T tmp = heap.get(size);
        size++;
        minHeapifyUp(index, tmp);
    }

    public void heapSort() {
        for (int i = size - 1; i >= 1; i--) {
            Collections.swap(heap, i, 0);
            size--;
            minHeapifyDown(0);
        }
        Collections.reverse(heap);
    }

    private void minHeapifyUp(int index, T element) {
        while (index > 0 && element.compareTo( heap.get(parent(index)) ) < 0) {
            heap.set(index, heap.get(parent(index)));
            index = parent(index);
        }
        heap.set(index, element);
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