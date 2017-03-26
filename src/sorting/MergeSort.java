package sorting;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public class MergeSort<T extends Comparable<T>> extends SortStrategy<T> {

	private ArrayList<T> elements;
	private ArrayList<T> auxillary;

	@Override
	public T[] sort(T[] unsortedArray) {
		//ToDo ...
		return null;
	}

	public MergeSort() {
		elements = new ArrayList<>();
		auxillary = new ArrayList<>();
	}

	@Override
	public ArrayList<T> sort(ArrayList<T> unsortedList) {
		elements = unsortedList;
		initializeAuxillary(elements.size());
		mergeSort(unsortedList, 0, unsortedList.size() - 1);
		return elements;
	}

	private void initializeAuxillary(int size) {
		for (int i = 0; i < size; i++) {
			auxillary.add(null);
		}
	}

	private void mergeSort(ArrayList<T> unsortedList, int first, int last) {
		if (first < last) {
			int middle = first + (last - first) / 2;
			mergeSort(unsortedList, first, middle);
			mergeSort(unsortedList, middle + 1, last);
			merge(unsortedList, first, middle, last);
		}
	}

	private void merge(ArrayList<T> unsortedList, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			auxillary.set(i, unsortedList.get(i));
		}
		int firstHalf = low;
		int secondHalf = middle + 1;
		int helperIndex = low;
		while (firstHalf <= middle && secondHalf <= high) {
			if (auxillary.get(firstHalf).compareTo(auxillary.get(secondHalf)) <= 0) {
				elements.set(helperIndex, auxillary.get(firstHalf));
				firstHalf++;
			} else {
				elements.set(helperIndex, auxillary.get(secondHalf));
				secondHalf++;
			}
			helperIndex++;
		}
		while (firstHalf <= middle) {
			elements.set(helperIndex, auxillary.get(firstHalf));
			firstHalf++;
			helperIndex++;
		}
		while (secondHalf <= high) {
			elements.set(helperIndex, auxillary.get(secondHalf));
			secondHalf++;
			helperIndex++;
		}
	}
}
