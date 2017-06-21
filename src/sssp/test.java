package sssp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class test {

	public static void main(String[] args) {
		int n, m;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		Graph<Integer> gp = new Graph<>(n, m);
		for (int i = 0; i < m; i++) {
			int src, dest, weight;
			src = input.nextInt();
			dest = input.nextInt();
			weight = input.nextInt();
			gp.addEdge(src, dest, weight);
		}
		int[] dist = new int[n];
		gp.runDijkstra(0, dist);
		//System.out.println(gp.runBellmanFord(0, dist));
		int[] distances = Dijkstra.getShortestDistanceArray();
		for (int i = 0; i < gp.size(); i++) {
			System.out.print(distances[i] + " ");
		}
		ArrayList<Integer> processedOrder = Dijkstra.getProcessedOrder();
		System.out.println();
		for (Integer x : processedOrder) {
			System.out.print(x + " ");
		}
	}
}
