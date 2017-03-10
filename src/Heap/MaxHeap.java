package Heap;

import exceptions.HeapIsEmptyException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap() {
        super(Type.MAX);
        heap = new ArrayList<>();
        size = 0;
    }

    public MaxHeap(T[] array) {
        super(Type.MAX);
        heap = new ArrayList<>(Arrays.asList(array));
        size = array.length;
        buildMaxHeap();
    }

    public MaxHeap(Collection<T> array) {
        super(Type.MAX);
        heap = new ArrayList<>(array);
        buildMaxHeap();
    }

    private void maxHeapifyDown(int i) {
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
            maxHeapifyDown(largest);
        }
    }

    private void buildMaxHeap() {
        for (int position = size/2 - 1; position >= 0; position--) {
            maxHeapifyDown(position);
        }
    }

    public T extractMax() throws HeapIsEmptyException {
        if (size < 1)
            throw new HeapIsEmptyException("Heap is empty.");
        size--;
        T maxElement = heap.get(0);
        heap.set(0, heap.get(size - 1));
        maxHeapifyDown(0);
        return maxElement;
    }
    @Override
    public void insert(T element) {
        heap.add(element);
        int index = size;
        T tmp = heap.get(size);
        size++;
        maxHeapifyUp(index, tmp);
    }

    private void maxHeapifyUp(int index, T element) {
        while (index > 0 && element.compareTo( heap.get(parent(index)) ) > 0) {
            heap.set(index, heap.get(parent(index)));
            index = parent(index);
        }
        heap.set(index, element);
    }

    @Override
    public void heapSort() {
        for (int i = size - 1; i >= 1; i--) {
            Collections.swap(heap, i, 0);
            size--;
            maxHeapifyDown(0);
        }
    }
}