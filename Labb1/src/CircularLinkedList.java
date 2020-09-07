import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> {

    static public int numberOfNodes;
    public Node head;
    public Node tail;

    public class Node {
        private Item item;
        private Node next;
    }

    public CircularLinkedList() {
        head = new Node();
        tail = new Node();
        head = tail;
    }

    public boolean isEmpty() {
        return numberOfNodes == 0;
    }

    public Iterator<Item> itemIterator(){
        return new CircularLinkedListIterator(head, tail);
    }

    private class CircularLinkedListIterator implements Iterator<Item>{

        public Node current;
        public Node tail;
        public CircularLinkedListIterator(Node head, Node tail){
            current = head;
            this.tail = tail;
        }

        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public void addFirst(Item item) {
        Node n = new Node();
        if(head == null){
            head = tail = n;
        }
        n.item = item;
        numberOfNodes++;
        tail.next = n;
        n.next = head;
        head = n;
        StdOut.println("\nElement: " + item.toString() + " has been added first in list");
        StdOut.println(); //print list
    }

    public void addLast(Item item) {
        Node n = new Node();
        if(head == null){
            head = tail = n;
        }
        n.item = item;
        numberOfNodes++;
        tail.next = n;
        n.next = head;
        tail = n;
        StdOut.println("\nElement: " + item.toString() + " has been added last in list");
        StdOut.println(); //print list
    }

    public void removeFirst() {
        Item item = head.item;
        if(numberOfNodes <= 0){
            StdOut.println("\n---No elements to remove--- ");
        }
        else {
            numberOfNodes--;
            tail.next = head.next;
            if(head.next!= null) {
                head = head.next;
            }
            else{
                head = tail;
            }
            StdOut.println("\nElement: " + item.toString() + " has been removed from first place");//Element som tagits bort
        }
    }

    public void removeLast() {
        Item item = tail.item;
        numberOfNodes--;
        if(numberOfNodes==0){
            head = tail = null;
            StdOut.println("dö");
            StdOut.println("\nElement: " + item.toString() + " has been removed"); //Element som tagits bort
        }

        Node current = head;
        while(current.next != tail){
            current = current.next;
            StdOut.println("Hej");
        }
        current.next = head;

        StdOut.println("\nElement: " + item.toString() +" has been removed"); //Element som tagits bort
    }

    public String listToString(){
        return null;
    }

    public static void main (String[] args){
        CircularLinkedList<Character> list = new CircularLinkedList<>();
        char c = 'a';
        list.addFirst(c);
        c = 'b';
        //list.addLast(c);
        list.addFirst(c);

        list.addLast(c);

        StdOut.println("Nr of nodes: " + numberOfNodes);

        list.removeFirst();
        StdOut.println("Nr of nodes: " + numberOfNodes);

        list.removeFirst();
        StdOut.println("Nr of nodes: " + numberOfNodes);

        list.removeFirst();
        StdOut.println("Nr of nodes: " + numberOfNodes);

        //list.removeLast();
    }

}
