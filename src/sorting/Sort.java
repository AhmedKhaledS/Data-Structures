package sorting;

import java.util.Collection;

/**
 * Created by Ahmed Khaled on 13/03/2017.
 */
public class Sort<T extends Comparable<T>> {

    private SortStrategy<T> sortingDelegate;

    public Sort(SortStrategy<T> sortingDelegate) {
        this.sortingDelegate = sortingDelegate;
    }

    public Collection<T> sort(Collection<T> unsortedList) {
        return sortingDelegate.sort(unsortedList);
    }
}
