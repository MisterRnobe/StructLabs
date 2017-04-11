package FirstLab;

/**
 * Created by Dell on 11.04.2017.
 */
public class OpenAddressing<K,V> extends HashMap<K,V>{
    private int capacity;
    private Node[] data;
    private Node<K,V> plug = new Node<>(null,null);
    public OpenAddressing(int capacity)
    {
        data = new Node[capacity];
        this.capacity = capacity;
        hasher = new Hashable() {
            @Override
            public int hash(Object o) {
                return o.hashCode()%capacity;
            }
        };
    }
    @Override
    public V get(K key) {
        int index;
        try {
            index = getNode(key);
        } catch (Exception e)
        {
            return null;
        }
        return (V)data[index].getValue();
    }

    @Override
    public void add(K key, V value) {
        int index = hasher.hash(key);
        for (int i = index; ; i=(i+1)%capacity) {
            if(data[i] == null) {
                data[i] = new Node<K, V>(key, value);
                break;
            }
        }
    }
    private int getNode(K key) throws Exception
    {
        int index = hasher.hash(key);
        int counter = 0;
        for (int i = index; data[i]!= null && counter < capacity; i = (i + 1)%capacity, counter++) {
            Node<K,V> node = (Node<K,V>)data[i];
            if (node.getKey() == null)
                continue;
            if (node.getKey().equals(key))
                return i;
        }
        throw new Exception("Element not found");
    }
    @Override
    public V remove(K key) {
        int index;
        try
        {
            index = getNode(key);
        }
        catch (Exception e)
        {
            return null;
        }
        V value = (V)data[index].getValue();
        data[index] = plug;
        return value;
    }
}
