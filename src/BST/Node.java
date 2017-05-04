package BST;

/**
 * Created by Dell on 12.04.2017.
 */
public class Node<K,V> {
    private Node<K,V> left,right;
    private V value;
    private K key;
    public Node(K key, V value, Node<K,V> left, Node<K,V> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
        this.key = key;
    }
    public Node(K key, V value)
    {
        this(key,value,null,null);
    }

    public Node<K,V> getLeft() {
        return left;
    }

    public void setLeft(Node<K,V> left) {
        this.left = left;
    }

    public Node<K,V> getRight() {
        return right;
    }

    public void setRight(Node<K,V> right) {
        this.right = right;
    }

    public V getValue() {
        return value;
    }
    public K getKey()
    {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public boolean hasLeft()
    {
        return left != null;
    }
    public boolean hasRight()
    {
        return right != null;
    }
}
