package heap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ahmed Khaled on 10/03/2017.
 */
public abstract class Heap<T extends Comparable<T>> implements
        PriorityQueue<T> {
    protected T[] heapArray;
//    protected boolean isCollection = false;
    protected List<T> heap;
    public int size;
    Type heapType;

    public Heap(Type heap) {
        this.heapType = heap;
    }
    public T[] getAsArray() {
        return null;
    }

    public Collection<T> getAsCollection() {
        return heap;
    }
    public Type getType() {
        return heapType;
    }

//    abstract public Collection<T> heapSort();
    abstract public void buildHeap();
    abstract public void heapify(int i);

    public void swap(int i, int j) {
        Collections.swap(heap, i, j);
    }

    public int parent(int i) {
        return (i - 1)/2;
    }

    public int left(int i) {
        return i*2 + 1;
    }

    public int right(int i) {
        return i*2 + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean hasLeft(int i) {
        return i*2 + 1 < size;
    }

    public boolean hasRight(int i) {
        return i*2 + 2 < size;
    }
}

