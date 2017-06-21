package sssp;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 * Represents a directed edge between two nodes of any data type.
 */
public class Edge<T> {

	private T source, destination;
	private double weight;

	/**
	 * Constructor that initialized the current edge with required information.
	 * @param source represents the source node of this edge.
	 * @param destination represents the destination node of this edge.
	 * @param weight represents the distance between the two nodes.
	 */
	public Edge(T source, T destination, double weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	/**
	 * Sets a new weight of this edge.
	 * @param newWeight represents the new weight of this edge.
	 */
	public void updateWeight(double newWeight) {
		this.weight = newWeight;
	}
}
