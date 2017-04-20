package Heap;

/**
 * Created by Dell on 16.03.2017.
 */
public class Heap <V> implements PriorityQueue<V> {
    public Node[] heap;
    private int length;
    public Heap(int capacity) {
        heap = new Node[getNextDegree(capacity)];//new ArrayList<>(capacity);
        length = 0;
    }
    @Override
    public void insert(Integer key, V value){
        if (length>=heap.length)
            throw new IndexOutOfBoundsException("Tree is full!");
        heap[length] = new Node(key, value);
        length++;
        for (int i = length - 1; i >= 0 && (int)heap[i].getKey() > (int)heap[i/2].getKey(); i/=2)
        {
            swap(i, i/2);
        }
    }
    private void swap(int i, int j)
    {
        Node<Integer,V> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    @Override
    public V deleteMax() {
        V value = (V)heap[0].getValue();
        heap[0] = heap[length - 1];
        length--;
        heapify(0);
        return value;
    }
    @Override
    public V getMax() {
        return (V)heap[0].getValue();
    }

    @Override
    public void editKey(Integer oldKey, Integer newKey) {
        // TODO: 13.04.2017
    }
    private void heapify(int i)
    {
        int leftChild;
        int rightChild;
        int largestChild;
        for(;;)
        {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < length && heap[leftChild].compareTo(heap[largestChild]) == 1)
            {
                largestChild = leftChild;
            }

            if (rightChild < length && heap[rightChild].compareTo(heap[largestChild]) == 1)
            {
                largestChild = rightChild;
            }

            if (largestChild == i)
            {
                break;
            }
            swap(i, largestChild);
            i = largestChild;
        }
    }
    public int getLength()
    {
        return length;
    }
    public static int getNextDegree(int i)
    {
        int counter = 1;
        do
        {
            i>>=1;
            counter++;
        }while (i > 1);

        int k = 1;
        for (int j = 0; j < counter; j++) {
            k<<=1;
        }
        return k;
    }
}
