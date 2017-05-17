package BinaryTree;

public class Test {
    public static void main(String[] args) throws Exception {
        BinaryTree<String, Integer> tree = new BinaryTree<String,Integer>("0",0);
        for (int i = 1; i < 10; i++) {
            tree.put(Integer.toString(i), i);
        }
        Frame f = new Frame(tree);
        f.isAlwaysOnTop();
        System.out.println(tree.find("1"));
        System.out.println(tree.find("2"));
        System.out.println(tree.find("3"));
        System.out.println(tree.find("4"));
        System.out.println(tree.find("5"));
        tree.remove("1");
        tree.put("5",5);
        tree.put("10",10);

    }
}
