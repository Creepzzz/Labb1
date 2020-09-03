import edu.princeton.cs.algs4.StdOut;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> {

    static public int numberOfNodes;
    private Node sentinel;


    public DoublyLinkedList(){
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    private class Node{
        private Item item;
        private Node next;
        private Node prev;
    }

    private boolean isEmpty(){
        if(numberOfNodes == 0){
            return true;
        }
        else return false;
    }

    private int size(){
        return numberOfNodes;
    }

    public void enqueue(Item item){
        Node n = new Node();
        n.item = item;
        numberOfNodes++;
        if(sentinel == null){
            n.next = n.prev = n;
            StdOut.println("\nElement: [" + item.toString()+ "] has been enqueued");
            return;
        }
        n.next = sentinel.next;
        n.prev = sentinel;
        sentinel.next = n;
        n.next.prev = n;
        StdOut.println("\nElement: [" + item.toString()+ "] has been enqueued");
        print();
    }

    public void dequeue(){
        if(numberOfNodes<=0){
            StdOut.println("No elements to dequeue");
        }
        else{
            numberOfNodes--;
            Item item = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            StdOut.println("\nElement: [" + item.toString() + "] has been dequeued");
            print();
        }
    }

    public void print(){
        StdOut.println(toString());
    }

    public String toString(){
        return printedQueue(sentinel.prev, new StringBuilder());
    }

    public String printedQueue(Node n, StringBuilder sb){
        return sb.toString();
    }



    public static void main(String[] args) {
        DoublyLinkedList<Character> doubly = new DoublyLinkedList<>();

        StdOut.println("\n-----Testing empty-----");
        StdOut.println("\nExpected number of nodes: 0 \nActual number of nodes: " + numberOfNodes);

        StdOut.println("\n-----Testing enqueue/dequeue a-----");
        char c = 'a';
        doubly.enqueue(c);
        StdOut.println("Expected enqueued element: a \nActual enqueued element is stated in brackets above");
        StdOut.println("Expected number of nodes: 1 \nActual number of nodes: " + numberOfNodes);
        doubly.dequeue();
        StdOut.println("Expected dequeued element: a \nActual dequeued element is stated in brackets above");
        StdOut.println("Expected number of nodes: 0 \nActual number of nodes: " + numberOfNodes);

        StdOut.println("\n-----Testing enqueue a and b then dequeue a and b still exists----");
        doubly.enqueue(c);
        c = 'b';
        doubly.enqueue(c);
        StdOut.println("Expected enqueued element: b \nActual enqueued element is stated in brackets above");
        StdOut.println("Expected number of nodes: 2 \nActual number of nodes: " + numberOfNodes);
        doubly.dequeue();
        StdOut.println("Expected dequeued element: a \nActual dequeued element is stated in brackets above");
        StdOut.println("Expected number of nodes: 1 \nActual number of nodes: " + numberOfNodes);

        StdOut.println("\n----Testing dequeue b----");
        doubly.dequeue();
        doubly.dequeue();
        StdOut.println(numberOfNodes);

    }
}
