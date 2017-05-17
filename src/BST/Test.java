package BST;

/**
 * Created by Dell on 12.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(2,"two");
        tree.put(1,"one");
        tree.put(5,"five");
        tree.put(4,"four");
        tree.put(3,"three");
        tree.put(0,"zero");
        tree.put(6,"six");
        tree.put(8,"eight");
        tree.put(7,"seven");
        tree.postOrderPrint().preOrderPrint().sortedPrint();
        System.out.println(String.format("Max is: %s, min is %s", tree.getMax(),tree.getMin()));

    }
}
