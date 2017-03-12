package sorting;

import java.util.Collection;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public abstract class Sort<T extends Comparable<T>> {
    abstract void sort(T[] array);
    abstract void sort(Collection<T> collection);
}
