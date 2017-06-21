package sssp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class Graph<T> implements IGraph {

	private int noOfVertices, noOfEdges;
	private List<Edge<T>> edges;
	private List<AdjacentNodeList> adjacencyList;
	private Graph<Integer> graph;
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
		Dijkstra.run(this, src, distances);
	}


	@Override
	public ArrayList<Integer> getDijkstraProcessedOrder() {
		return Dijkstra.getProcessedOrder();
	}

	@Override
	public boolean runBellmanFord(int src, int[] distances) {
		return BellmanFord.run(this, src, distances);
	}

	@Override
	public void readGraph(File file) {
		try {
			Scanner input = new Scanner(file);
			int n, m;
			n = input.nextInt();
			m = input.nextInt();
			graph = new Graph<>(n, m);
			for (int i = 0; i < m; i++) {
				int src, dest, weight;
				src = input.nextInt();
				dest = input.nextInt();
				weight = input.nextInt();
				graph.addEdge(src, dest, weight);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void bellmanFord(File file) {
		int[] dist = new int[graph.size()];
		try {
			PrintWriter writer = new PrintWriter(file.getName().substring(0,
					file.getName().length() - 4) + "_output"
					+ ".txt", "UTF-8");
			writer.write(Boolean.toString(graph.runBellmanFord(0, dist)));
			writer.println();
			int[] distances = BellmanFord.getShortestDistanceArray();
			if (!BellmanFord.containsNegativeCycles) {
				for (int i = 0; i < graph.size(); i++) {
					writer.write(distances[i] + " ");
				}
			}
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	public void dijkstra(File file) {
		int[] dist = new int[graph.size()];
		try {
			PrintWriter writer = new PrintWriter(file.getName().substring(0,
					file.getName().length() - 4) + "_output"
					+ ".txt", "UTF-8");
			graph.runDijkstra(0, dist);
			int[] shortestDistances = Dijkstra.getShortestDistanceArray();
			for (int i = 0; i < shortestDistances.length; i++) {
				writer.write(Integer.toString(shortestDistances[i]) + " ");
			}
			writer.println();
			ArrayList<Integer> processedOrder = Dijkstra
					.getProcessedOrder();
			for (Integer tmp : processedOrder) {
				writer.write(tmp.toString() + " ");
			}
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

}
