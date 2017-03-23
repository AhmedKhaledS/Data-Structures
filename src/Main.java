import sorting.InsertionSort;
import sorting.Sort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ahmed Khaled on 13/03/2017.
 */
public class Main {

    public static void  main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.println("Please Enter size of the data set");
        n = scan.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer x = scan.nextInt();
            nums.add(x);
        }
        Sort<Integer> sort = new Sort<>(new InsertionSort<Integer>());
        sort.sort(nums);
        for (int  i = 0; i < n; i++) {
            System.out.print(nums.get(i) + " ");
        }
    }
}
