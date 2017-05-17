package Dictionary;

/**
 * Created by Dell on 11.05.2017.
 */
class Node<K extends Comparable<K>,V> {
    Node<K,V> left, right;
    K key;
    V value;
    Node(K key, V value, Node<K,V> left, Node<K,V> right)
    {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
    Node(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Key: "+key.toString()+"; Value: "+value.toString();
    }
}
