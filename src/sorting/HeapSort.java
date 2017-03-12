package sorting;

import heap.Heap;
import heap.MaxHeap;


import java.util.Collection;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public T[] sort(T[] array) {
        //ToDo ...
        return null;
    }

    @Override
    public Collection<T> sort(Collection<T> collection) {
        Heap<T> heap = new MaxHeap<T>(collection);
        heap.buildHeap();
        for (int i = heap.size - 1; i > 0; i--) {
            heap.swap(i, 0);
            heap.size--;
            heap.heapify(0);
        }

        return heap.getAsCollection();
    }
}
