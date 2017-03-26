package heap;

import exceptions.HeapIsEmptyException;

/**
 * Created by Ahmed Khaled on 12/03/2017.
 */
public interface PriorityQueue<T extends Comparable<T>> {
	public void insert(T element);

	public T extractFront() throws HeapIsEmptyException;
}
