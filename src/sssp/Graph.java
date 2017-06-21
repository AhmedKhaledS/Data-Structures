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

	public Graph(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		edges = new ArrayList<>(noOfEdges);
		adjacencyList = new ArrayList<>(noOfVertices);
	}

	public void addEdge(int src, int dest, int weight) {
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


	public AdjacentNodeList getNeighbourVertices(int vertexID) {
		return this.adjacencyList.get(vertexID);
	}

	public List<Edge<T>> getEdges() {
		return this.edges;
	}

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
	public boolean runBellmanFord(int src, int[] distances) {
		return BellmanFord.run(this, src, distances);
	}

	@Override
	public void readGraph(File file) {

	}

}
