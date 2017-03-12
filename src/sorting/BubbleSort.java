package sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public class BubbleSort<T extends Comparable<T>> extends SortStrategy<T> {

    @Override
    public T[] sort(T[] unsortedArray) {
        //ToDo ...
        return null;
    }

    @Override
    public ArrayList<T> sort(ArrayList<T> collection) {
        boolean swapped = true;
        for (int i = 0; i < collection.size() && swapped; i++) {
            swapped = false;
            for (int j = 0; j < collection.size() - 1; j++) {
                if (collection.get(j).compareTo(collection.get(j + 1)) > 0) {
                    Collections.swap(collection, j, j + 1);
                    swapped = true;
                }
            }
        }
        return collection;
    }
}
