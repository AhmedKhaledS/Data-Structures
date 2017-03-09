import java.util.Collection;
import java.util.List;

/**
 * Created by Ahmed Khaled on 09/03/2017.
 */
public class Test {
    public static void main(String argv[]) {
        String[] arr = {"c", "b", "aaa", "a"};
        MaxHeap<String> mx = new MaxHeap<>(arr);
        mx.insert("aa");
        mx.insert("bb");
        mx.insert("z");
        mx.insert("sa");
        mx.insert("aaaabbababasasva");
        mx.heapSort();
        Collection<String> res = mx.getAsCollection();
        for (String x : res) {
            System.out.println(x);

        }
    }
}
