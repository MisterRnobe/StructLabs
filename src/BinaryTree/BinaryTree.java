package BinaryTree;

/**
 * Created by Dell on 19.04.2017.
 */
public class BinaryTree<K extends Comparable<K>,V> {
    private Node<K,V> root;
    public BinaryTree(K key, V value)
    {
        this.root = new Node<K, V>(key,value);
    }
    public void put(K key, V value)
    {
        Node<K,V> inserted = new Node<K, V>(key,value);
        Node<K,V> current = root;
        int left = current.getLeft(), right = current.getRight();
        while (!(left == 0 || right == 0))
        {
            boolean degreeLeft = isDegreeOf2(left+1), degreeRight = isDegreeOf2(right+1);
            if (degreeRight)
            {
                if (degreeLeft && left>right) {
                    current.increaseRight();
                    current = current.getRightNode();
                }
                else
                {
                    current.increaseLeft();
                    current = current.getLeftNode();
                }
            }
            else
            {
                current.increaseRight();
                current = current.getRightNode();
            }

            left = current.getLeft();
            right = current.getRight();
        }
        if (left == 0)
        {
            current.setLeftNode(inserted);
        }
        else
            current.setRightNode(inserted);
    }
    public V find(K key)
    {
        Node<K,V> node = find(key, root);
        return node == null? null: node.getValue();

    }
    private Node<K,V> find(K key, Node<K,V> node)
    {
        Node<K,V> current = null;
        if (node.getKey().compareTo(key) == 0)
            return node;
        else
        {

            if (node.getLeft()  != 0)
                current = find(key, node.getLeftNode());
            if (node.getRight() != 0 && current == null)
                current = find(key, node.getRightNode());
        }
        return current;
    }
    public Node<K,V> root()
    {
        return root;
    }
    public static boolean isDegreeOf2(int num)
    {
        if (num % 2 == 0 && num > 1)
            return isDegreeOf2(num>>1);
        else
        if (num == 1)
            return true;
        else
            return false;
    }
}
