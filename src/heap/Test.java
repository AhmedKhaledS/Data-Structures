package heap;

import java.util.Collection;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class Test {
    public static void main(String argv[]) {
        Integer[] arr = new Integer[0];
        PriorityQueue<Integer> pq = new MinHeap<>(arr);
        pq.insert(12);
        pq.insert(124);
        pq.insert(-10100);
        try {
            System.out.println(pq.extractFront());
            pq.insert(10100);
            pq.insert(222222);
            pq.insert(222222);
            pq.insert(222222);

            System.out.println(pq.extractFront());
            System.out.println(pq.extractFront());
            System.out.println(pq.extractFront());
            System.out.println(pq.extractFront());
            System.out.println(pq.extractFront());
            System.out.println(pq.extractFront());
            pq.insert(-22);
            pq.insert(14);
            System.out.println(pq.extractFront());
            System.out.println(pq.extractFront());
        } catch (Exception e) {
            System.out.println("Empty heap.");
        }
        Heap<String> hp = new MinHeap<>();
        hp.insert("naggar");
        hp.insert("h-e");
        hp.insert("naggar");
        hp.insert("khaled");
        hp.insert("bolta");
        hp.heapSort();
        for (String x : hp.getAsCollection()) {
            System.out.println(x);
        }
//        mx.heapSort();
//        Collection<String> res = mx.getAsCollection();
//        for (String x : res) {
//            System.out.println(x);
//
//        }
    }
}
