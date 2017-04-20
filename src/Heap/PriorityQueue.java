package Heap;
/**
 * Created by Dell on 16.03.2017.
 */
public interface PriorityQueue<V> {
    void insert(Integer key, V value);
    V deleteMax();
    V getMax();
    void editKey(Integer oldKey, Integer newKey);
}
