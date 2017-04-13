package BTS;

/**
 * Created by Dell on 12.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        BinaryTreeSearch<Integer, String> tree = new BinaryTreeSearch<>();
        tree.put(2,"two");
        tree.put(1,"one");
        tree.put(5,"five");
        tree.put(4,"four");
        tree.put(3,"three");
        /*tree.put(1, "one");
        tree.put(2, "two");
        tree.put(3, "three");
        tree.put(4, "four");*/
        tree.print();
        System.out.println();
        //tree.remove(2);
        //tree.remove(5);
        System.out.println(tree.remove(1));
        tree.print();
        //System.out.println(tree.get(3));
    }
}
