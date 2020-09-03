import edu.princeton.cs.algs4.StdOut;

public class DoublyLinkedList<Item> {

    private Node beforeFirst;
    private Node afterLast;
    static public int numberOfNodes;


    public DoublyLinkedList(){
        beforeFirst = new Node();
        afterLast = new Node();
        beforeFirst.next = afterLast;
        afterLast.prev = beforeFirst;
    }

    private class Node{
        private Item item;
        private Node next;
        private Node prev;
    }

    public void enqueue(Item item){
        Node last = afterLast.prev;
        Node n = new Node();
        n.item = item;
        n.next = beforeFirst;
        n.prev = last;
        afterLast.prev = n;
        last.next = n;
        numberOfNodes++;
        StdOut.println("\nElement: [" + item.toString()+ "] has been enqueued");
        print();
    }

    public void dequeue(){
        if(numberOfNodes<=0){
            StdOut.println("No elements to dequeue");
        }
        else{
            afterLast.prev.prev.next = beforeFirst;
            beforeFirst.prev = afterLast.prev.prev;
            Node n = afterLast.prev;
            //StdOut.println(n.item.toString());
            Item item = n.item;
            numberOfNodes--;
            StdOut.println("\nElement: [" + item.toString() + "] has been dequeued");
            print();
        }
    }

    public void print(){
        StdOut.println(toString());
    }

    public String toString(){
        return printedQueue(beforeFirst, new StringBuilder());
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
