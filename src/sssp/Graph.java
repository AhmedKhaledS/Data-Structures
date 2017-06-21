package sssp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class Graph<T> implements IGraph {

	private int noOfVertices, noOfEdges;
	private List<Edge<T>> edges;
	private List<AdjacentNodeList> adjacencyList;

	/**
	 * Main Constructor to initialize the data-fields with default values.
	 */
	public Graph() {
		this.noOfVertices = 0;
		this.noOfEdges = 0;
		edges = new ArrayList<>();
		adjacencyList = new ArrayList<>();
	}

	/**
	 * Constructor to initialize tthe number of nodes and edges in the graph.
	 * @param noOfVertices The number nodes in the graph.
	 * @param noOfEdges The number of edges in the graph.
	 */
	public Graph(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		edges = new ArrayList<>();
		adjacencyList = new ArrayList<>(noOfVertices);
		for (int i = 0; i < noOfVertices; i++) {
			adjacencyList.add(new AdjacentNodeList());
		}
	}

	/**
	 * Adds new Edge to the graph with the given data.
	 * @param src Represents the parent node to be added.
	 * @param dest Represents the child node to be added.
	 * @param weight Represents the weight between the Parent and the Child
	 *                  node.
	 */
	public void addEdge(int src, int dest, int weight) {
		edges.add((Edge<T>) new Edge<Integer>(src, dest, weight));
		adjacencyList.get(src).addNode(dest, weight);
	}

	/**
	 * Gets the graph as adjacency-list data structure.
	 * @return Return the assigned graph in adjacency list representation.
	 */
	public List<AdjacentNodeList> getAsAdjacencyList() {
		return adjacencyList;
	}

	/**
	 * Gets the all neighbour nodes(Children) to the given node(Parent).
	 * @param vertexID The ID of the parent vertex.
	 * @return Returns the adjacency-list representation of the graph.
	 */
	public AdjacentNodeList getNeighbourVertices(int vertexID) {
		return this.adjacencyList.get(vertexID);
	}

	/**
	 * Gets the graph in array-list of edges structure.
	 * @return Return the list contatining all edges in the graph.
	 */
	public List<Edge<T>> getEdges() {
		return this.edges;
	}

	/**
	 * This returns the number of edges in the graph.
	 * @return Returns the number of edges in the graph.
	 */
	public int getNoOfEdges() {
		return this.noOfEdges;
	}

	@Override
	public ArrayList<Integer> getVertices() {
		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			vertices.add(i);
		}
		return (ArrayList<Integer>) vertices;
	}

	@Override
	public int size() {
		return this.noOfVertices;
	}

	@Override
	public ArrayList<Integer> getNeighbors(int v) {
		return getNeighbourVertices(v).getAdjNodes();
	}

	@Override
	public void runDijkstra(int src, int[] distances) {

	}


	@Override
	public ArrayList<Integer> getDijkstraProcessedOrder() {
		return null;
	}

	@Override
	public int[] runBellmanFord(int src, int[] distances) {
		return BellmanFord.run(this, src, distances);
	}

	@Override
	public void readGraph(File file) {

	}

}
