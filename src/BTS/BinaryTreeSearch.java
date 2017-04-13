package BTS;

/**
 * Created by Dell on 12.04.2017.
 */
public class BinaryTreeSearch<K extends Comparable<K>, V> {
    public Node<K,V> root;
    private int count;

    public BinaryTreeSearch(K key, V value)
    {
        this.root = new Node<>(key,value);
        count = 1;
    }
    public BinaryTreeSearch()
    {
        this.root = null;
        count = 0;
    }

    public void put(K key, V value)
    {
        Node<K,V> insertedNode = new Node<>(key,value);
        if (root == null)
        {
            root = insertedNode;
            return;
        }
        Node<K,V> current = root;
        Node<K,V> parent;
        for(;;)
        {
            parent = current;
            switch (current.getKey().compareTo(key))
            {
                case 0:
                case 1:
                {
                    current = current.getLeft();
                    if (current == null)
                    {
                        parent.setLeft(insertedNode);
                        return;
                    }
                    break;
                }
                case -1:
                {
                    current = current.getRight();
                    if (current == null)
                    {
                        parent.setRight(insertedNode);
                        return;
                    }
                    break;
                }
            }
        }
    }
    public V get(K key)
    {

        Node<K,V> current = root;
        for(;;)
        {
            switch (current.getKey().compareTo(key))
            {
                case 1:
                {
                    if (current.hasLeft())
                        current = current.getLeft();
                    else
                        return null;
                    break;
                }
                case 0:
                {
                    return current.getValue();
                }
                case -1:
                {
                    if (current.hasRight())
                    {
                        current = current.getRight();
                    }
                    else
                        return null;
                    break;
                }
            }
        }
    }
    private V removeRoot()
    {
        Node<K,V> current = root;
        if (!root.hasLeft() && !root.hasRight())
        {
            root = null;
        }
        else
        if(root.hasLeft() && root.hasRight())
        {
            Node<K,V> node = root.getRight(), parent = root;
            while (node.hasLeft())
            {
                parent = node;
                node = node.getLeft();
            }
            parent.setLeft(node.getRight());
            node.setLeft(current.getLeft());
            node.setRight(current.getRight());
            root = node;
        }
        else
        {
            if (root.hasLeft())
                root = root.getLeft();
            else
                root = root.getRight();
        }
        return current.getValue();
    }
    public V remove(K key)
    {
        if (key.compareTo(root.getKey()) == 0)
            return removeRoot();
        Node<K,V> current = root;
        Node<K,V> parent = root;

        while (current.getKey().compareTo(key) != 0)
        {
            parent = current;
            if (current.getKey().compareTo(key) == -1)
            {
                if (current.hasRight())
                    current = current.getRight();
                else
                    return null;
            }
            else
                if (current.hasLeft())
                    current = current.getLeft();
                else
                    return null;
        }
        if (!current.hasLeft() && !current.hasRight())
        {
            Node<K,V> node = current;
            if (current == parent.getLeft())
                parent.setLeft(null);
            else
                parent.setRight(null);
            return node.getValue();
        }
        else
        if(current.hasLeft() && current.hasRight())
        {
            Node<K,V> newNode = current.getRight();
            Node<K,V> newNodeParent = current;
            while (newNode.hasLeft())
            {
                newNodeParent = newNode;
                newNode = newNode.getLeft();
            }
            newNodeParent.setLeft(newNode.getRight());
            newNode.setLeft(current.getLeft());
            newNode.setRight(current.getRight());
            if (parent.getLeft() == current)
                parent.setLeft(newNode);
            else
                parent.setRight(newNode);
            return current.getValue();
        }
        else
        {
            if (current.hasLeft())
            {
                if (parent.getLeft() == current)
                    parent.setLeft(current.getLeft());
                else
                    parent.setRight(current.getLeft());
            }
            else
            {
                if (parent.getRight() == current)
                    parent.setLeft(current.getRight());
                else
                    parent.setRight(current.getRight());
            }
            return current.getValue();
        }
    }
    public void print()
    {
        print(root);
    }
    private void print(Node<K,V> v)
    {
        if (v.getLeft() != null)
        {
            print(v.getLeft());
        }
        System.out.print(v.getValue()+" ");
        if (v.getRight() != null)
            print(v.getRight());
    }
}
