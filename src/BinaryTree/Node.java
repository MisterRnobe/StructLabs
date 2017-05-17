package BinaryTree;

/**
 * Created by Dell on 19.04.2017.
 */
class Node<K,V> {
    private Node<K,V> leftNode,rightNode, parent;
    private int left, right;
    private K key;
    private V value;
    Node(K key, V value, Node<K,V> left, Node<K,V> right)
    {
        this.key = key;
        this.value = value;
        this.leftNode = left;
        this.rightNode = right;
        if (leftNode == null)
            this.left = 0;
        else
            this.left = left.left+ left.right + 1;
        if (leftNode == null)
            this.right = 0;
        else
            this.right = right.left+ right.right + 1;
        parent = null;

    }
    Node(K key, V value)
    {
        this(key,value,null,null);
    }

    public Node<K, V> getLeftNode() {
        return leftNode;
    }

    public Node<K, V> getParent() {
        return parent;
    }

    public void increaseLeft()
    {
        left++;
    }
    public void increaseRight()
    {
        right++;
    }
    public void decreaseLeft()
    {
        left--;
    }
    public void decreaseRight()
    {
        right--;
    }

    public void setParent(Node<K, V> parent) {
        this.parent = parent;
    }

    public void setLeftNode(Node<K, V> leftNode) {
        this.leftNode = leftNode;
        if (leftNode == null)
            return;
        this.left++;
        leftNode.parent = this;
    }

    public Node<K, V> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<K, V> rightNode) {
        this.rightNode = rightNode;
        if (rightNode == null)
            return;
        this.right++;
        rightNode.parent = this;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public String toString()
    {
        return key.toString()+"->"+value.toString();
    }
}
