import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class BinaryHeap extends PriorityQueue{
    private ArrayList<?> heap;

    public BinaryHeap() {
        heap = new ArrayList<>();
    }

    public BinaryHeap(Object[] array) {
        heap = new ArrayList<>(Arrays.asList(array));
    }

    public BinaryHeap(List array) {
        heap = new ArrayList<>(array);
    }

    public BinaryHeap(Collection array) {
        heap = new ArrayList<>(Arrays.asList(array));
    }

    public void buildMaxHeap() {

    }

    public void buildtMinHeap() {

    }

    public void maxHeapify() {

    }
    public void minHeapify() {

    }

    public void insert(Object element) {

    }

    public void deleteMax() {

    }

    public void deleteMin() {
    }
}
