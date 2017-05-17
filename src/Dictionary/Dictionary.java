package Dictionary;

/**
 * Created by Dell on 11.05.2017.
 */
public interface Dictionary<K extends Comparable<K>,V, S extends Dictionary<K,V,S>> {
    V get(K key);
    S put(K key, V value);
    S postOrderPrint();
    S preOrderPrint();
}
