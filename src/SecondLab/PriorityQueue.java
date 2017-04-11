package SecondLab;
/**
 * Created by Dell on 16.03.2017.
 */
public interface PriorityQueue<V> {
    void insert(Integer key, V value);
    V deleteMin();
    V deleteMax();
    V getMin();
    V getMax();
    void decreaseKey(V value);
    void increaseKey(V value);

}
