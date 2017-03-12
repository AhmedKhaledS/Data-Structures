package sorting;

import java.util.Collection;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public interface Sort<T extends Comparable<T>> {
    abstract T[] sort(T[] array);
    abstract Collection<T> sort(Collection<T> collection);
}
