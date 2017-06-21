package trees.AVL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class Test {
	public static void main(String[] args) {
		IDictionary dict = new Dictionary();
		System.out.println(dict.size());
		dict.insert("ahmed");
		dict.insert("khaled");
		dict.insert("Saad");
		dict.insert("hassan");
		dict.insert("Seif");
		System.out.println(dict.height());
		System.out.println(dict.size());
		System.out.println(dict.exists("ahmed"));
		dict.insert("11");
		dict.insert("2");
		dict.insert("2");
		dict.insert("333");
		dict.delete("Saad");
		System.out.println(dict.exists("Seif"));
		System.out.println(dict.exists("Saad"));
		System.out.println(dict.height());
		System.out.println(dict.size());

		/*dict.load(new File("src/trees/AVL/dictionary.txt"));
		try (BufferedReader buffer = new BufferedReader(new FileReader
				("src/trees/AVL/dictionary.txt"))) {
			String word;
			while ((word = buffer.readLine()) != null) {
				if (!dict.exists(word)) {
					System.out.println("Error");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		dict.delete("6th");
		System.out.println(dict.exists("6th"));
	}*/
	}
}
