package Heap;

/**
 * Created by Dell on 16.03.2017.
 */
public class Node<K extends Comparable<K>,V> implements Comparable<Node<K,V>> {
    private K key;
    private V value;
    public Node(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node<K, V> node) {
        return key.compareTo(node.getKey());
    }

    @Override
    public String toString() {
        return key.toString()+" : "+getValue().toString();
    }
}
