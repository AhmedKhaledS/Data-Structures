package sssp;

import java.util.*;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class Dijkstra {

	private static ArrayList<Integer> processedOrder;
	private static int[] shortestDistanceArray;
	private static boolean[] processed;

	/**
	 * This method runs Dijkstra's algorithm on the passed graph and assigns
	 * the shortest path tree and processed order array.
	 * @param graph The graph which will processed to get the shortest path
	 *                 tree.
	 * @param src The source node to scan the graph from.
	 * @param distances Th array of distances containing the distances from
	 *                     the source node.
	 */
	public static void run(Graph graph, int src, int[] distances) {
		processedOrder = new ArrayList<>(graph.size());
		shortestDistanceArray = new int[graph.size()];
		processed = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			distances[i] = Integer.MAX_VALUE;
			processed[i] = false;
		}
		distances[src] = 0;
		PriorityQueue<Pair<Integer, Integer>> pQueue = new PriorityQueue<>(graph
				.size(), new MinComparator());
		pQueue.add(new Pair<>(0, src));
		while (!pQueue.isEmpty()) {
			Pair<Integer, Integer> currentNode = pQueue.peek();
			pQueue.poll();
			if (currentNode.att2 != distances[currentNode.att1]) {
				continue;
			}
			//processedOrder.add(currentNode.att1);
			ArrayList<Pair<Integer, Integer>> setOfNeighbours
					= (ArrayList<Pair<Integer, Integer>>) graph.
					getNeighbourVertices(currentNode.att1)
					.getAdjNodesWithData();

			for (Pair<Integer, Integer> child : setOfNeighbours) {
					if (distances[child.att1] > child.att2 + currentNode.att2) {
						distances[child.att1] = child.att2 + currentNode.att2;
						pQueue.add(new Pair<>(child.att1, distances[child
								.att1]));
					}
			}
		}
		shortestDistanceArray = distances;
		processedOrder = getProcessedOrderList();
	}

	/**
	 * Gets the array holding the shortest distance from source node to all
	 * other nodes.
	 * @return Return the array of distances from the source to other nodes.
	 */
	public static int[] getShortestDistanceArray() {
		return shortestDistanceArray;
	}

	/**
	 * Gets the array holding the order of processing after applying Dijkstra.
	 * @return Return the array of order of processing after applying Dijkstra.
	 */
	public static ArrayList<Integer> getProcessedOrder() {
		return processedOrder;
	}

	/**
	 * Inner-class to implement Comparator function manually in order to have
	 * the compatibility to be applied with Pairs.
	 */
	static class MinComparator implements Comparator<Pair<Integer, Integer>> {

		@Override
		public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
			return o1.att2 - o2.att2;
		}
	}

	private static ArrayList<Integer> getProcessedOrderList() {
		ArrayList<Pair<Integer, Integer>> shortestPathTree = new ArrayList<>();
		for (int i = 0; i < shortestDistanceArray.length; i++) {
			shortestPathTree.add(new Pair<>(i, shortestDistanceArray[i]));
		}
		Collections.sort(shortestPathTree, new MinComparator());
		ArrayList<Integer> processedOrderTree = new ArrayList<>();
		for (Pair<Integer, Integer> pr : shortestPathTree) {
			processedOrderTree.add(pr.att1);
		}
		return processedOrderTree;
	}
}
