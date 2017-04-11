package FirstLab;

import java.util.Collection;

/**
 * Created by Dell on 11.04.2017.
 */
public abstract class HashMap<K,V>{
    protected Hashable hasher;
    protected static final int stdCapacity = 100;
    public abstract V get(K key);
    public abstract void add(K key, V value);
    public abstract V remove(K key);

    public static <K,V> HashMap<K,V> createChaining(int capacity)
    {
        return new Chaining<K,V>(capacity);
    }
    public static <K,V> HashMap<K,V> createChaining()
    {
        return new Chaining<K,V>();
    }
    public static <K,V> HashMap<K,V> createAddressing(int capacity)
    {
        return new OpenAddressing<K, V>(capacity);
    }
    public static <K,V> HashMap<K,V> createAddressing()
    {
        return new OpenAddressing<K, V>(stdCapacity);
    }
}
