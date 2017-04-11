package FirstLab;

public class OpenAddressing<K,V> extends HashMap<K,V>{
    private int count;
    private Node[] data;
    private Node<K,V> plug = new Node<>(null,null);
    private static final float rate = 0.8f;

    private int constant;

    OpenAddressing(int capacity)
    {
        data = new Node[getNextPrime(capacity)];
        this.count = 0;
        this.constant = capacity-1;
        hasher = o -> o.hashCode()%getNextPrime(capacity);
    }
    @Override
    public V get(K key) {
        int index = getIndex(key);
        if (index == -1)
            return null;
        else
            return ((Node<K,V>)data[index]).getValue();
    }

    @Override
    public void add(K key, V value) {
        int index = hasher.hash(key);
        if (data[index] == null || data[index] == plug)
        {
            data[index] = new Node(key,value);
        }
        else
        {
            int step = constant - (hasher.hash(key) - constant);
            for(index = (index+step)%data.length; data[index] != null; index = (index+step)%data.length);
            data[index] = new Node(key,value);
        }
        count++;

    }
    private int getIndex(K key)
    {
        int index;
        int step = constant - (hasher.hash(key) - constant);
        Node<K,V> node;
        for(index = hasher.hash(key); data[index] != null; index = (index+step)%data.length)
        {
            node = (Node<K, V>) data[index];
            if (node.getKey()!= null && node.getKey().equals(key))
                return index;
        }
        return -1;
    }
    @Override
    public V remove(K key) {
        int index = getIndex(key);
        if (index == -1)
            return null;
        else
        {
            Node<K,V> node = (Node<K,V>)data[index];
            data[index] = plug;
            count--;
            return node.getValue();
        }
    }
    public static int getNextPrime(int num)
    {
        int result = num - 1;
        boolean isPrime;
        do
        {
            isPrime = true;
            result++;
            for (int i = 2; i < result/2; i++) {
                if (result%i == 0)
                {
                    isPrime = false;
                    break;
                }
            }
        }while (!isPrime);
        return result;
    }
    public void print()
    {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null )
                System.out.print("(0 : 0), ");
            else
                if (data[i] == plug)
                    System.out.print("(PLUG), ");
            else
                System.out.print("("+data[i].getKey()+" : "+data[i].getValue()+"), ");
        }
        System.out.println();
    }
    private void expand()
    {
        int newCapacity = getNextPrime(data.length * 12 / 10);

    }

}
