package trees.AVL;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class Dictionary implements IDictionary {

	private IAVLTree<String> tree;
	private int size;

	/**
	 * Default constructor initializes the the AVL tree.
	 */
	public Dictionary() {
		size = 0;
		tree = new AVLTree<>();
	}

	@Override
	public void load(File file) {
		size = 0;
		tree = new AVLTree<>();
		try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
			String word;
			while ((word = buffer.readLine()) != null) {
				tree.insert(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(String word) {
		if (exists(word)) {
			return false;
		}
		tree.insert(word);
		size++;
		return true;
	}

	@Override
	public boolean exists(String word) {
		if (tree.search(word)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String word) {
		if (tree.delete(word)) {
			size--;
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int height() {
		return tree.height();
	}
}
