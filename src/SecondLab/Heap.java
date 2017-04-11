package SecondLab;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Dell on 16.03.2017.
 */
public class Heap <V> implements PriorityQueue {
    public Node[] heap;
    private int length;
    public Heap(int capacity) {
        heap = new Node[capacity];//new ArrayList<>(capacity);
        length = 0;
    }
    @Override
    public void insert(Integer key, Object value){
        if (length>=heap.length)
            return;
            //throw new IndexOutOfBoundsException("The heap is full!");
        heap[length] = new Node(key, value);
        length++;
        for (int i = length - 1; i >= 0 && (int)heap[i].getKey() > (int)heap[i/2].getKey(); i/=2)
        {
            swap(i, i/2);
        }

    }

    @Override
    public V deleteMin() {
        return null;
    }
    private void swap(int i, int j)
    {
        Node<Integer,V> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    @Override
    public V deleteMax() {
        return (V)heap[0].getValue();
    }

    @Override
    public Object getMin() {
        return null;
    }

    @Override
    public Object getMax() {
        return null;
    }

    @Override
    public void decreaseKey(Object value) {

    }

    @Override
    public void increaseKey(Object value) {

    }
    public int getLength()
    {
        return length;
    }

}
