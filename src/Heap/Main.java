package Heap;

/**
 * Created by Dell on 30.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(12);
        heap.insert(1,"one");
        heap.insert(6,"six");
        heap.insert(0,"zero");
        heap.insert(4,"four");
        heap.insert(5,"five");
        heap.insert(3,"three");
        heap.insert(2,"two");
        heap.insert(7,"seven");
        for (int i = 0; i < heap.getLength(); i++) {
            System.out.println(heap.heap[i]+" ");
        }
        heap.deleteMax();
        System.out.println("===================");
        for (int i = 0; i < heap.getLength(); i++) {
            System.out.println(heap.heap[i]+" ");
        }
        heap.insert(8,"eight");
        System.out.println("===================");
        for (int i = 0; i < heap.getLength(); i++) {
            System.out.println(heap.heap[i]+" ");
        }
        System.out.print("Delete: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(heap.deleteMax()+" ");
        }
        System.out.println();
        System.out.println("===================");
        for (int i = 0; i < heap.getLength(); i++) {
            System.out.println(heap.heap[i]+" ");
        }
    }
}
