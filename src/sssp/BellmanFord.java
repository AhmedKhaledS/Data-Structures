package sssp;

import java.util.ArrayList;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class BellmanFord {

	/**
	 * Boolean to determeine whether the assigned graph has negative cycles
	 * or not.
	 */
	static boolean containsNegativeCycles = false;

	/**
	 * Runs Bellman-Ford Single-Source-Shortest-Path algorithm to the
	 * assigned graph and returns the the shortest distances from the source
	 * node to all other nodes.
	 * @param graph Represents the graph structure.
	 * @param src The source node to travel from.
	 * @param distances The array containing all distances to other nodes
	 *                     with respect to the source node.
	 * @return Returns the shortest path array from the source node to all
	 *         other nodes.
	 */
	public static int[] run(Graph graph, int src, int[] distances) {
		for (int i = 0; i < graph.size(); i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[src] = 0;
		for (int i = 1; i <= graph.size() - 1; i++) {
			ArrayList<Edge<Integer>> setOfEdges =
					(ArrayList<Edge<Integer>>) graph.getEdges();
			for (Edge<Integer> e : setOfEdges) {
				int source = e.source;
				int destination = e.destination;
				int weight = e.weight;
				if (distances[source] != Integer.MAX_VALUE
						&& distances[source] + weight
						< distances[destination]) {
					distances[destination] = distances[source] + weight;
				}
			}
		}

		ArrayList<Edge<Integer>> setOfEdges
				= (ArrayList<Edge<Integer>>) graph.getEdges();
		for (Edge<Integer> e : setOfEdges) {
			int source = e.source;
			int destination = e.destination;
			int weight = e.weight;
			if (distances[source] != Integer.MAX_VALUE
					&& distances[source] + weight
					< distances[destination]) {
				BellmanFord.containsNegativeCycles = true;
				break;
			}
		}
		return distances;
	}
}
