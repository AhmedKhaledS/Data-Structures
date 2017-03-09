import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class MaxBinaryHeap {

    private List<? extends Comparable> heap;
    private int size;

    public MaxBinaryHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    public MaxBinaryHeap(Comparable[] array) {
        heap = new ArrayList<>(Arrays.asList(array));
        size = array.length;
    }

    public MaxBinaryHeap(Collection<? extends Comparable> array) {
        heap = new ArrayList<>(array);
    }

    public void maxHeapInsert(Object element) {
        size++;
    }

    public Object[] getAsArray() {
        return heap.toArray();
    }

    public Collection<?> getAsCollection() {
        return heap;
    }

    private void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = -1;
        if (left < size && heap.get(left).compareTo(heap.get(i)) > 0 ) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0 ) {
            largest = right;
        } else {
            largest = i;
        }
        if (largest != i) {
            Collections.swap(heap, i, largest);
            maxHeapify(largest);
        }
    }

    private void buildMaxHeap() {
        for (int position = size / 2; position >= 0; position--) {
            maxHeapify(position);
        }
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

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }

    private boolean hasLeft(int i) {
        return i * 2 < size;
    }

    private boolean hasRight(int i) {
        return i * 2 + 1 < size;
    }
}
