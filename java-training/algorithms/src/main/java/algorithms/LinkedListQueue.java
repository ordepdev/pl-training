package algorithms;

import java.util.Iterator;

// This algorithm is a generic and iterable implementation of
// a Queue based on a linked-list data structure. It can be used
// to create queues containing any type of data.

public class LinkedListQueue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(T item) {
        Node tmp = last;
        last = new Node(item, null);
        if (isEmpty()) first = last;
        else           tmp.next = last;
        N++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<T> iterator() {
        return new LinkedListQueueIterator();
    }

    private class LinkedListQueueIterator implements Iterator<T> {

        private Node current = first;

        public boolean hasNext() { return current != null; }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() { }
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        System.out.println("size: " + queue.size());
        for (int v: queue) {
            System.out.println(v);
        }

        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }

        System.out.println("size: " + queue.size());

    }
}
