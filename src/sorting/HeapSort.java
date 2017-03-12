package sorting;

import heap.Heap;
import heap.MaxHeap;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public class HeapSort<T extends Comparable<T>> extends SortStrategy<T> {
    @Override
    public T[] sort(T[] unsortedArray) {
        //ToDo ...
        return null;
    }

    @Override
    public ArrayList<T> sort(ArrayList<T> collection) {
        Heap<T> heap = new MaxHeap<T>(collection);
        heap.buildHeap();
        for (int i = heap.size - 1; i > 0; i--) {
            heap.swap(i, 0);
            heap.size--;
            heap.heapify(0);
        }
        return (ArrayList)heap.getAsCollection();
    }
}
