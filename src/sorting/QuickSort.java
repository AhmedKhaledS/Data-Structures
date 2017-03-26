package sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public class QuickSort<T extends Comparable<T>> extends SortStrategy<T> {
	public QuickSort() {

	}

	@Override
	public T[] sort(T[] unsortedArray) {
		//ToDo ...
		return null;
	}

	@Override
	public ArrayList<T> sort(ArrayList<T> unsortedList) {
		quickSort(unsortedList, 0, unsortedList.size() - 1);
		return unsortedList;
	}

	private void quickSort(ArrayList<T> unsortedList, int low, int high) {
		if (low < high) {
			int pivot = partition(unsortedList, low, high);
			quickSort(unsortedList, low, pivot - 1);
			quickSort(unsortedList, pivot + 1, high);
		}
	}

	private int partition(ArrayList<T> unsortedList, int low, int high) {
		T pivot = unsortedList.get(high);
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (unsortedList.get(j).compareTo(pivot) <= 0) {
				i++;
				Collections.swap(unsortedList, i, j);
			}
		}
		Collections.swap(unsortedList, i + 1, high);
		return i + 1;
	}

}
