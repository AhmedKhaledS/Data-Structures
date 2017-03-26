package sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public class SelectionSort<T extends Comparable<T>> extends SortStrategy<T> {

	public SelectionSort() {
	}

	@Override
	public T[] sort(T[] unsortedArray) {
		//ToDo ...
		return null;
	}

	@Override
	public ArrayList<T> sort(ArrayList<T> collection) {
		for (int i = 0; i < collection.size(); i++) {
			int min = i;
			for (int j = i + 1; j < collection.size(); j++) {
				if (collection.get(j).compareTo(collection.get(min)) < 0) {
					min = j;
				}
			}
			Collections.swap(collection, i, min);
		}
		return collection;
	}
}