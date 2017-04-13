package HashMap;
import java.util.LinkedList;

/**
 * Created by Dell on 15.03.2017.
 */
public class Chaining<K,V> extends HashMap<K,V>{
    private LinkedList[] data;
    private int capacity;
    public Chaining(int capacity)
    {
        data = new LinkedList[capacity];
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
            data[i] = new LinkedList<Node<K,V>>();
        }
        hasher = new Hashable() {
            @Override
            public int hash(Object o) {
                return o.hashCode()%capacity;
            }
        };
    }
    public Chaining()
    {
        this(stdCapacity);
    }

    public void add(Node<K,V> element)
    {
        int index = hasher.hash(element.getKey());

        data[index].addLast(element);
    }
    public void add(K key, V value)
    {
        this.add(new Node<>(key,value));
    }

    public V get(K key)
    {
        int index = hasher.hash(key);
        for (Object element: data[index]) {
            Node<K,V> node = (Node<K,V>) element;
            if( node.getKey().equals(key))
            {
                return (node.getValue());
            }
        }
        return null;
    }
    private Node<K,V> findNode(K key)
    {
        int index = hasher.hash(key);
        for (Object o: data[index]) {
            Node<K,V> node = (Node<K,V>)o;
            if (node.getKey().equals(key))
                return node;
        }
        return null;
    }
    public V remove(K key)
    {
        int index = hasher.hash(key);
        Node<K,V> node = findNode(key);
        if (node == null)
            return null;
        data[index].remove(node);
        return node.getValue();
    }
}
