package sssp;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class Pair<T1, T2> {

	public T1 att1;
	public T2 att2;

	/**
	 * Consructor to initialize the required fields.
	 * @param p1 the first attribute.
	 * @param p2 the second attribute.
	 */
	public Pair(T1 p1, T2 p2) {
		this.att1 = p1;
		this.att2 = p2;
	}
}
