package SecondLab;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Dell on 30.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(new Integer(3), 3);
        heap.insert(new Integer(5), 5);
        heap.insert(new Integer(1), 1);
        heap.insert(new Integer(2), 2);
        heap.insert(new Integer(7), 7);
        heap.insert(new Integer(9), 9);
        heap.insert(new Integer(6), 6);
        for (int i = 0; i < 6; i++) {
           //System.out.println(heap.heap.length);
            System.out.println(heap.heap[i].getValue());
        }
    }
}
