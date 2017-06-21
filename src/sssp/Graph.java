package sssp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class Graph<T> {

	private int noOfVertices, noOfEdges;
	private List<Edge<T>> edges;
	private List<Integer> vertices;
	private List<AdjacentNodeList> adjacencyList;

	/**
	 * Main Constructor to initialize the data-fields with default values.
	 */
	public Graph() {
		this.noOfVertices = 0;
		this.noOfEdges = 0;
		edges = new ArrayList<>();
		vertices = new ArrayList<>();
		adjacencyList = new ArrayList<>();
	}

	public Graph(int noOfEdges, int noOfVertices) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		edges = new ArrayList<>(noOfEdges);
		vertices = new ArrayList<>(noOfVertices);
		adjacencyList = new ArrayList<>(noOfVertices);
	}

	public void addEdge(int src, int dest, double weight) {
		edges.add((Edge<T>) new Edge<Integer>(src, dest, weight));
		if (adjacencyList.get(src) == null ) {
			AdjacentNodeList node = adjacencyList.get(src);
			node = new AdjacentNodeList();
		}
		adjacencyList.get(src).addNode(dest, weight);
	}

	public List<AdjacentNodeList> getAsAdjacencyList() {
		return adjacencyList;
	}

	public ArrayList<Integer> getVertices() {
		return (ArrayList<Integer>) vertices;
	}

	public int size() {
		return this.noOfVertices;
	}

	public AdjacentNodeList getNeighbours(int vertexID) {
		return this.adjacencyList.get(vertexID);
	}

	public Edge<Integer> getEdges() {
		return (Edge<Integer>) this.edges;
	}
}
