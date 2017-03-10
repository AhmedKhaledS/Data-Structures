package Heap;

import java.util.Collection;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class Test {
    public static void main(String argv[]) {
        Integer[] arr = {1, 22, 3, 2};
        Heap.MinHeap<Integer> mx = new Heap.MinHeap<>(arr);
        mx.insert(12);
        mx.insert(11);
        mx.insert(10);
        mx.insert(36);
        mx.insert(2);
        mx.heapSort();
        Collection<Integer> res = mx.getAsCollection();
        for (Integer x : res) {
            System.out.println(x);

        }
    }
}
