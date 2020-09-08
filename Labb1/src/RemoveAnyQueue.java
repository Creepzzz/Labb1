/* Author: Matilda Qvick 001105-0606
   Generated: 28/8 - 2020
   Last updated: 8/9 - 2020
   Solves: Creates a queue of elements (with an addFirst method)
           and removes the kth element in the queue. The queue work
           with any generic type and the queue is printed after each
           insertion and deletion of an element.
   How to use: The class does  take input from standard input, there
               viewer should write the index one wants to remove.
               The main method tests both enqueue and dequeue
               of elements. The iterator is also tested as well as
               a counter for the nodes.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RemoveAnyQueue<Item> implements Iterable<Item>{

    /**
     * Class node containing attributes of next node and item
     */
    private class Node{
        public Node next;
        public Item item;
    }

    /**
     * Declaring local variables for first and last element as well as a counter for nodes
     */
    public Node head, tail;
    private int numberOfNodes;

    /**
     * Constructor of queue, queue is empty from the start
     */
    public RemoveAnyQueue(){
        numberOfNodes = 0;
    }

    /**
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty(){
        return numberOfNodes == 0;
    }

    /**
     * Constructor of iterator
     * @return queue iterator
     */
    @Override
    public Iterator<Item> iterator() {
        return new RemoveAnyQueueIterator(head, tail);
    }

    /**
     *Class for queue iterator implementing iterator
     */
    private class RemoveAnyQueueIterator implements Iterator<Item>{
        Node current, tail;
        int i = 0;

        /**
         * Constructor of queue iterator
         * @param head is the first node of queue
         * @param tail is the last node if queue
         */
        public RemoveAnyQueueIterator(Node head, Node tail){
            current = head;
            this.tail = tail;
        }

        /**
         *
         * @return true if there is a next element in the queue
         */
        @Override
        public boolean hasNext() {
            return i<numberOfNodes;
        }

        /**
         *
         * @return the next item in the queue
         */
        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            i++;
            return item;
        }
    }

    /**
     * Enqueues given element and puts it on index one
     * Makes the queue circular
     * Increases the number of nodes
     * @param item to be enqueued
     */
    public void enqueue(Item item){
        Node n = new Node();
        n.item = item;
        numberOfNodes++;
        if(head == null){
            head = tail = n;
            StdOut.println(queueToString());
            return;
        }
        n.next = head;
        head = n;
        tail.next = n;
        StdOut.println(queueToString());
    }

    /**
     * Removes the element on the kth position in the queue
     * Makes the queue circular
     * Decreases the number of nodes
     * @param k is the position of wanted removed element
     */
    public void removeK(int k){
        Node current = head;
        Node foundNode;
        k = k-1;
        int i = 1;
        if(isEmpty()|| (k < 0) || (k > numberOfNodes)){
            throw new NoSuchElementException();
        }
        else if(k == 0){
            foundNode = current;
            head = current.next;
        }
        else {
            while(i < k){
                current = current.next;
                i++;
            }
            foundNode = current.next;
        }
        current.next = current.next.next;
        numberOfNodes--;
        StdOut.println("\nRemoved element nr " + (k+1) +": " + foundNode.item);
        StdOut.println(queueToString());
    }

    /**
     *
     * @return a string representation of the queue
     */
    public String queueToString(){
        Node n = head;
        int i = 0;
        if(isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        while (i< numberOfNodes){
            sb.append("[");
            sb.append(n.item.toString());
            sb.append("],");
            n = n.next;
            i++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /**
     * Hard coded tests including:
     * Testing empty queue and counts nodes
     * Testing enqueueing and dequeueing the kth element from stdin and count nodes
     * Testing iterator and method hasNext before and after dequeueing all elements
     * @param args
     */
    public static void main(String[] args){
        RemoveAnyQueue<Character> queue = new RemoveAnyQueue<Character>();
        StdOut.println("\n---Testing empty queue---");
        StdOut.println(queue.queueToString());
        StdOut.println("\nShould be: true, is actually: " + queue.isEmpty());
        StdOut.println("Expected number of node: 0 \nActual number of nodes: " + queue.numberOfNodes);

        StdOut.println("\n---Testing dequeue element nr k---");
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');

        StdOut.println("Write the index of the element you want to remove");
        int k = StdIn.readInt();
        queue.removeK(k);
        StdOut.println("Expected number of node: 3 \nActual number of nodes: " + queue.numberOfNodes);

        StdOut.println("\n---Testing iterator---");
        StdOut.println(queue.iterator().hasNext());
        StdOut.println("Should say: true");
        queue.removeK(1);
        queue.removeK(1);
        queue.removeK(1);
        StdOut.println(queue.iterator().hasNext());
        StdOut.println("Should say: false");
    }
}
