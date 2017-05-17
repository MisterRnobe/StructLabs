package Dictionary;

/**
 * Created by Dell on 11.05.2017.
 */
public class DictionaryTree<K extends Comparable<K>,V> implements Dictionary<K,V,DictionaryTree<K,V>> {
    private Node<K,V> root;
    DictionaryTree(K key, V value)
    {
        this.root = new Node<K, V>(key,value);
    }
    @Override
    public V get(K key) {
        Node<K,V> current = root;
        for(;;)
        {
            switch (current.key.compareTo(key))
            {
                case 1:
                {
                    if (current.left != null)
                        current = current.left;
                    else
                        return null;
                    break;
                }
                case 0:
                {
                    return current.value;
                }
                case -1:
                {
                    if (current.right!= null)
                    {
                        current = current.right;
                    }
                    else
                        return null;
                    break;
                }
            }
        }
    }

    @Override
    public DictionaryTree<K, V> put(K key, V value) {
        Node<K,V> insertedNode = new Node<K,V>(key,value);
        if (root == null)
        {
            root = insertedNode;
            return this;
        }
        Node<K,V> current = root;
        Node<K,V> parent;
        for(;;)
        {
            parent = current;
                if (current.key.compareTo(key) <= 0)
                {
                    current = current.left;
                    if (current == null)
                    {
                        parent.left = insertedNode;
                        return this;
                    }
                }
                else
                {
                    current = current.right;
                    if (current == null)
                    {
                        parent.right = insertedNode;
                        return this;
                    }
                }
        }
    }


    @Override
    public DictionaryTree<K, V> postOrderPrint() {
        System.out.println("Post order: ");
        printPost(root);
        System.out.println();
        return this;
    }
    private void printPost(Node node)
    {
        if (node.right != null)
            printPost(node.right);
        if (node.left != null)
            printPost(node.left);
        System.out.print(node + "| ");
    }

    @Override
    public DictionaryTree<K, V> preOrderPrint() {
        System.out.println("Pre order: ");
        printPre(root);
        System.out.println();
        return this;
    }
    private void printPre(Node node)
    {
        System.out.print(node + "| ");
        if (node.right != null)
            printPost(node.right);
        if (node.left != null)
            printPost(node.left);
    }
    public V remove(K key)
    {
        if (key.compareTo(root.key) == 0)
            return null;
        Node<K,V> current = root;
        Node<K,V> parent = root;

        while (current.key.compareTo(key) != 0)
        {
            parent = current;
            if (current.key.compareTo(key) < 0)
            {
                if (current.right != null)
                    current = current.right;
                else
                    return null;
            }
            else
            if (current.right != null)
                current = current.left;
            else
                return null;
        }
        if (!(current.right != null) && !(current.right != null))
        {
            Node<K,V> node = current;
            if (current == parent.left)
                parent.left = null;
            else
                parent.right = null;
            return node.value;
        }
        else
        if(current.right != null && current.right != null)
        {
            Node<K,V> newNode = current.right;
            Node<K,V> newNodeParent = current;
            while (newNode.right != null)
            {
                newNodeParent = newNode;
                newNode = newNode.left;
            }
            newNodeParent.left = newNode.right;
            newNode.left = current.left;
            newNode.right = current.right;
            if (parent.left == current)
                parent.left = newNode;
            else
                parent.right = newNode;
            return current.value;
        }
        else
        {
            if (current.right != null)
            {
                if (parent.left == current)
                    parent.left = current.left;
                else
                    parent.right = current.left;
            }
            else
            {
                if (parent.right == current)
                    parent.left = (current.right);
                else
                    parent.right = (current.right);
            }
            return current.value;
        }
    }
}
