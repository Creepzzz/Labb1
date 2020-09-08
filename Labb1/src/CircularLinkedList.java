/* Author: Matilda Qvick 001105-0606
   Generated: 28/8 - 2020
   Last updated: 8/9 - 2020
   Solves: Creates a linked circular list where elements can
           be added first and last in the list as well as removed
           from the first and last position. The list is generic
           and circular. After each deletion or insertion, the list
           is printed out
   How to use: The class does not take input from standard input.
               In the main method there are hard coded tests, testing all
               features of the class, dequeue, enqueue, hasNext, next a well
               as counting the number of existing nodes. 
 */

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> implements Iterable<Item> {

    /**
     * Class node containing attributes next and item
     */
    private class Node{
        public Node next;
        public Item item;
    }

    /**
     * Declaring global variables
     */
    private Node head, tail;
    private int numberOfNodes;

    /**
     * Constructor of new empty list
     */
    public CircularLinkedList(){
         numberOfNodes = 0;
    }

    /**
     * Fixes the index to a positive int
     * @return if the list is empty
     */
     public boolean isEmpty(){
        if(numberOfNodes<0){
            numberOfNodes++;
        }
         return numberOfNodes == 0;
     }

    /**
     * Constructor of an iterator
     * @return list iterator
     */
    @Override
    public Iterator<Item> iterator() {
        return new CircularLinkedListIterator(head, tail);
    }

    /**
     * Class Circular List Iterator which implements iterator of generic type
     */
    private class CircularLinkedListIterator implements Iterator<Item>{

        Node current, tail;

        /**
         * Constructor of Circular list iterator
         * @param head is the first node
         * @param tail is the last node
         */
        public CircularLinkedListIterator(Node head, Node tail){
            current = head;
            this.tail = tail;
        }

        /**
         *
         * @return true if there is a next element in the list
         */
        @Override
        public boolean hasNext() {
            return current != tail;
        }

        /**
         *
         * @return the next item in the list
         */
        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Takes in an element and adds it to the first place in the list, declaring the new node as the head
     * (and tail if the list was empty).
     * Makes the list circular
     * Increases the number of nodes
     * Prints out the list after each element is added
     * @param item is the element to be added to the start of list
     */
    public void addFirst(Item item){
        numberOfNodes++;
        Node n = new Node();
        n.item = item;
        if(head == null){
            head = tail = n;
            StdOut.println(listToString());
            return;
        }
        n.next = head;
        head = n;
        tail.next = head;
        StdOut.println(listToString());
    }

    /**
     * Takes in an element and adds it to the last position in the list, declaring the new node as tail
     * (and head if the list was empty).
     * Makes the list circular.
     * Increases the number of nodes
     * Prints te list after each element is added.
     * @param item is the element to be added to the end of list
     */
    public void addLast(Item item){
        numberOfNodes++;
        Node n = new Node();
        n.item = item;
        if(head == null){
            head = tail = n;
            StdOut.println(listToString());
            return;
        }
        tail.next = n;
        tail = n;
        tail.next = head;
        StdOut.println(listToString());
    }

    /**
     * Dereferences the node at the start of the list. The second to first node becomes the new head.
     * Makes the list circular.
     * Decreases the number of nodes
     * Prints out the list after each removal of first element
     */
    public void removeFirst(){
        numberOfNodes--;
        if(isEmpty()){
            head = tail = null;
            StdOut.println(listToString());
            return;
        }
        head = head.next;
        tail.next = head;
        StdOut.println(listToString());
    }

    /**
     * Dereferences the node at the end of the list. The second to last node becomes the new tail.
     * Makes the list circular
     * Decreases the number of nodes
     * Prints out the list after each removal of last element
     */
    public void removeLast(){
        numberOfNodes--;
        if (isEmpty()){
            head = tail = null;
            StdOut.println(listToString());
            return;
        }
        Node n = head;
        while (n.next != tail){
            n = n.next;
        }
        tail = n;
        tail.next = head;
        StdOut.println(listToString());
    }

    /**
     *
     * @return a string representation of the list
     */
    public String listToString(){
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
     * Testing empty list and nodes
     * Testing adding to first place and count nodes
     * Testing removing from first place and count nodes
     * Testing adding to last place and count nodes
     * Testing removing from last place and count nodes
     * Testing removing from empty list and count nodes
     * Testing iterator hasNext when empty and not empty and count nodes
     * Testing iterator next and count nodes
     * @param args
     */
    public static void main(String[] args){
        CircularLinkedList<Character> list = new CircularLinkedList<>();

        StdOut.println("\n---Testing empty list---");
        StdOut.println(list.listToString());
        StdOut.println("Expected number of nodes: 0 \nActual number of nodes: " + list.numberOfNodes);

        StdOut.println("\n---Testing adding a to first place, then b, then c---");
        list.addFirst('a');
        list.addFirst('b');
        list.addFirst('c');
        StdOut.println("Last list should look: [c],[b],[a]");
        StdOut.println("Expected number of nodes: 3 \nActual number of nodes: " + list.numberOfNodes);

        StdOut.println("\n---Testing removing elements from first place---");
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        StdOut.println("Elements should be removed in the following order: c, b, a");
        StdOut.println("Expected number of nodes: 0 \nActual number of nodes: " + list.numberOfNodes);

        StdOut.println("\n---Testing adding a to last place, then b, then c---");
        list.addLast('a');
        list.addLast('b');
        list.addLast('c');
        StdOut.println("\nLast list should look: [a],[b],[c]");
        StdOut.println("Expected number of nodes: 3 \nActual number of nodes: " + list.numberOfNodes);

        StdOut.println("\n---Testing removing elements from last place---");
        list.removeLast();
        list.removeLast();
        list.removeLast();
        StdOut.println("\nElements should be removed in the following order: c, b, a");
        StdOut.println("Expected number of nodes: 0 \nActual number of nodes: " + list.numberOfNodes);

        StdOut.println("\n---Testing removing elements from an empty list---");
        list.removeLast();
        list.removeFirst();
        StdOut.println("Expected number of nodes: 0 \nActual number of nodes: " + list.numberOfNodes);

        StdOut.println("\n---Testing iterator hasNext---");
        StdOut.println("List has no elements, expected result: false \nActual result: " + list.iterator().hasNext());
        list.addFirst('a');
        list.addFirst('b');
        StdOut.println("List has two elements, expected result: true \nActual result: "+ list.iterator().hasNext());
        StdOut.println("Expected number of nodes: 2 \nActual number of nodes: " + list.numberOfNodes);

        StdOut.println("\n---Testing iterator next---");
        StdOut.println("Next element in list is b \nActual next is: " + list.iterator().next().toString());
        StdOut.println("Expected number of nodes: 2 \nActual number of nodes: " + list.numberOfNodes);
    }
}

