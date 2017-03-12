package heap;

import sorting.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IntSummaryStatistics;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class Test {
    public static void main(String argv[]) {
        ArrayList<String> x = new ArrayList<>();
        x.add("tolba");
        x.add("naggar");
        x.add("terny");
        x.add("hisham");
        x.add("khaled");
        x.add("zzz");
        Sort<String> sortt = new Sort(new SelectionSort<String>());
        ArrayList<String> ans = sortt.sort(x);
        for (String res : ans) {
            System.out.println(res);
        }
        ArrayList<Integer> xx = new ArrayList<>();
        xx.add(10);
        xx.add(16);
        xx.add(13);
        xx.add(1);
        xx.add(5);
        xx.add(620);
        Sort<Integer> sorttt = new Sort(new SelectionSort<Integer>());
        ArrayList<Integer> anss = sorttt.sort(xx);
        for (Integer res : anss) {
            System.out.println(res);
        }
        /*Integer[] arr = new Integer[0];
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
        }*/
//        mx.heapSort();
//        Collection<String> res = mx.getAsCollection();
//        for (String x : res) {
//            System.out.println(x);
//
//        }
    }
}
