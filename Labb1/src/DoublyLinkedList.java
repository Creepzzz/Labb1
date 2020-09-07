import edu.princeton.cs.algs4.StdOut;

public class DoublyLinkedList<Item>
 {
    static public int numberOfNodes;
    private Node sentinel;

     /**
      * Constructor of list
      */
    public DoublyLinkedList(){
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

     /**
      * Class node with attributes item and node previous and next
      */
    private class Node{
        private Item item;
        private Node next;
        private Node prev;
    }

     /**
      *
      * @return true if list is empty
      */
    private boolean isEmpty(){
        return numberOfNodes == 0;
    }

     /**
      * Puts item at the end of a queue and makes sentinel node next point to it,
      * previous node points to sentinel and n is declared as last element of the queue
      * @param item to be enqueued
      */
    public void enqueue(Item item){
        Node n = new Node();
        n.item = item;
        numberOfNodes++;
        n.next = sentinel.next;
        n.prev = sentinel;
        sentinel.next = n;
        n.next.prev = n;
        StdOut.println("\nElement: '" + item.toString()+ "' has been enqueued");
        StdOut.println(queueToString());
    }

     /**
      * Unless the queue is empty, the node pointing to the fist element in the queue
      * is dereferenced and the second to first element is declared as the first by moving
      * the node sentinel to that item. The sentinel previous node is moved to the last
      * enqueued item in order to keep the list circular.
      */
    public void dequeue(){
        if(numberOfNodes<=0){
            StdOut.println("\n!!! No elements to dequeue !!!");
        }
        else{
            numberOfNodes--;
            Item item = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            StdOut.println("\nElement: '" + item.toString() + "' has been dequeued");
        }
        StdOut.println(queueToString());
    }

     /**
      *
      * @return a string representation of the queue
      */
    public String queueToString(){
        Node n = sentinel.prev;
        int i = 0;
        if(isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();

        while(i < numberOfNodes){
            sb.append("[");
            sb.append(n.item.toString());
            sb.append("],");
            n = n.prev;
            i++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

     /**
      * Hard coded tests including:
      * Testing empty queue
      * Testing enqueue and dequeue one item
      * Testing enqueue and dequeue several objects
      * Testing dequeue from empty queue
      * @param args
      */
    public static void main(String[] args) {
        DoublyLinkedList<Character> doubly = new DoublyLinkedList<>();
        StdOut.println("\n-----Testing empty-----");
        StdOut.print(doubly.queueToString());
        StdOut.println("\nExpected number of nodes: 0 \nActual number of nodes: " + numberOfNodes);

        StdOut.println("\n-----Testing enqueue/dequeue a-----");
        char c = 'a';
        doubly.enqueue(c);
        StdOut.println("Expected enqueued element: a \nActual enqueued element is stated in ' ' above");
        StdOut.println("Expected number of nodes: 1 \nActual number of nodes: " + numberOfNodes);
        doubly.dequeue();
        StdOut.println("Expected dequeued element: a \nActual dequeued element is stated in ' ' above");
        StdOut.println("Expected number of nodes: 0 \nActual number of nodes: " + numberOfNodes);

        StdOut.println("\n-----Testing enqueue a and b then dequeue a and b still exists----");
        doubly.enqueue(c);
        c = 'b';
        doubly.enqueue(c);
        StdOut.println("Expected enqueued element: a, b \nActual enqueued element is stated in ' ' above");
        StdOut.println("Expected number of nodes: 2 \nActual number of nodes: " + numberOfNodes);
        doubly.dequeue();
        StdOut.println("Expected dequeued element: a \nActual dequeued element is stated in ' ' above");
        StdOut.println("Expected number of nodes: 1 \nActual number of nodes: " + numberOfNodes);

        StdOut.println("\n----Testing dequeue b----");
        doubly.dequeue();
        StdOut.println("Expected dequeued element: b \nActual dequeued element is stated in ' ' above");
        doubly.dequeue();
        StdOut.println("Expected number of nodes: 0 \nActual number of nodes: " + numberOfNodes);

    }
}
