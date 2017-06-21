package sssp;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ahmed Khaled on 21/06/2017.
 */
public class test {

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>();
		File file1 = new File("C:\\Users\\Ahmed " +
				"Khaled\\git\\data-structures\\src\\sssp" +
				"\\graphs_testCases_2017\\belman_ford_1.txt");
		g.readGraph(file1);
		g.bellmanFord(file1);
		BellmanFord.containsNegativeCycles = false;

		File file2 = new File("C:\\Users\\Ahmed " +
				"Khaled\\git\\data-structures\\src\\sssp" +
				"\\graphs_testCases_2017\\belman_ford_2.txt");
		g.readGraph(file2);
		g.bellmanFord(file2);
		BellmanFord.containsNegativeCycles = false;

		File file3 = new File("C:\\Users\\Ahmed " +
				"Khaled\\git\\data-structures\\src\\sssp" +
				"\\graphs_testCases_2017\\belman_ford_3.txt");

		g.readGraph(file3);
		g.bellmanFord(file3);
		BellmanFord.containsNegativeCycles = false;

		File file4 = new File("C:\\Users\\Ahmed " +
				"Khaled\\git\\data-structures\\src\\sssp" +
				"\\graphs_testCases_2017\\dijkstra_1.txt");
		g.readGraph(file4);
		g.dijkstra(file4);

		File file5 = new File("C:\\Users\\Ahmed " +
				"Khaled\\git\\data-structures\\src\\sssp" +
				"\\graphs_testCases_2017\\dijkstra_2.txt");
		g.readGraph(file5);
		g.dijkstra(file5);

		File file6 = new File("C:\\Users\\Ahmed " +
				"Khaled\\git\\data-structures\\src\\sssp" +
				"\\graphs_testCases_2017\\dijkstra_3.txt");
		g.readGraph(file6);
		g.dijkstra(file6);

	}
}
