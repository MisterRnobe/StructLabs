package BinaryTree;
/**
 * Created by Dell on 19.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree<String, Integer> tree = new BinaryTree<String,Integer>("0",0);
        for (int i = 1; i < 5; i++) {
            tree.put(Integer.toString(i), i);
        }
        new Frame(tree);
        System.out.println(tree.find("1"));
        System.out.println(tree.find("2"));
        System.out.println(tree.find("3"));
        System.out.println(tree.find("4"));
        System.out.println(tree.find("5"));
        //System.out.println(BinaryTree.isDegreeOf2(5));

    }
}
