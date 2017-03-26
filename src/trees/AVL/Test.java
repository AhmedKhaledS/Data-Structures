package trees.AVL;

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

	}
}
