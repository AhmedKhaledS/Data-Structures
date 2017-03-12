package sorting;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public class InsertionSort<T extends Comparable<T>> extends SortStrategy<T> {
    public InsertionSort() {}

    @Override
    public T[] sort(T[] unsortedArray) {
        //ToDo ...
        return null;
    }

    @Override
    public ArrayList<T> sort(ArrayList<T> unsortedList) {
        for (int i = 1; i < unsortedList.size(); i++) {
            T cur = unsortedList.get(i);
            int j;
            for (j = i - 1; j >= 0 && cur.compareTo(unsortedList.get(j)) < 0; j--) {
                unsortedList.set(j + 1, unsortedList.get(j));
            }
            unsortedList.set(j + 1, cur);
        }
        return unsortedList;
    }
}
