package heap;

import java.util.Collection;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class Test {
    public static void main(String argv[]) {
        String[] arr = {"a", "ahmed", "3", "2"};
        Heap<String> mx = new MinHeap<String>(arr);
        mx.insert("12");
        mx.insert("zz");
        mx.insert("asads1");
        mx.heapSort();
        Collection<String> res = mx.getAsCollection();
        for (String x : res) {
            System.out.println(x);

        }
    }
}
