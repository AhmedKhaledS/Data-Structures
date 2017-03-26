package sorting;

import java.util.ArrayList;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public abstract class SortStrategy<T extends Comparable<T>> {
	public SortStrategy() {
	}

	abstract public T[] sort(T[] unsortedArray);

	abstract public ArrayList<T> sort(ArrayList<T> unsortedList);
}
