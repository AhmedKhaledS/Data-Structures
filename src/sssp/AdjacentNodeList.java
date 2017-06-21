package sssp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class AdjacentNodeList {

	private List<Pair<Integer, Double>> adjNodes;
	private List<Integer> adjacentNodes;


	public AdjacentNodeList() {
		adjNodes = new ArrayList<>();
		adjacentNodes = new ArrayList<>();
	}
	/**
	 * Constructor to initialize the set of neighbor nodes with the passed data.
	 * @param nodes the array-list that holds the neighbour nodes with data.
	 */
	public AdjacentNodeList(ArrayList<Pair<Integer, Double>> nodes) {
		adjNodes = nodes;
		adjacentNodes = new ArrayList<Integer>();
		for (Pair pr : nodes) {
			adjacentNodes.add((Integer) pr.att1);
		}
	}

	/**
	 * Returns the neighbour nodes of certatin node.
	 * @return Array-list containing all neighbours.
	 */
	public ArrayList<Integer> getAdjNodes() {
		return (ArrayList<Integer>) adjacentNodes;
	}

	/**
	 * Adds new node the neighbour-list.
	 * @param node The new node-ID to be added.
	 * @param weight The weight of this node w.r.t the parent node.
	 */
	public void addNode(int node, double weight) {
		adjNodes.add(new Pair<>(node, weight));
		adjacentNodes.add(node);
	}

	/**
	 * Gets the node number "index" linked by the parent node.
	 * @param index The node number linked by the parent node.
	 * @return Returns the pre-specified node holding its data.
	 */
	public Pair<Integer, Double> getAdjNode(int index) {
		return this.adjNodes.get(index);
	}

}
