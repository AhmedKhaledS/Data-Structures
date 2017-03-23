package trees.AVL;

/**
 * Created by Ahmed Khaled on 23/03/2017.
 */
public class Test {
    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>("aaa");
        tree.insert("ahmed");
        tree.insert("khaled");
        tree.insert("saad");
        tree.insert("Hassan");
        tree.insert("Seif");
        tree.insert("1");
        tree.insert("2");
        tree.insert("333");
        tree.insert("22");
        System.out.println(tree.search("aaa"));
    }
}
