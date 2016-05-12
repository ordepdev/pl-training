package algorithms;

import java.util.Iterator;

// This algorithm is a generic and iterable implementation of
// the Stack API based on a linked-list data structure. It can be used
// to create stacks containing any type of data.

public class LinkedListStack<T> implements Iterable<T> {

    private Node first;
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

    public void push(T item) {
        Node tmp = first;
        first = new Node(item, tmp);
        N++;
    }


    public T pop() {
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<T> iterator() {
        return new LinkedListStackIterator();
    }

    private class LinkedListStackIterator implements Iterator<T> {

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

        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println("size: " + stack.size());
        for (int v: stack) {
            System.out.println(v);
        }

        for (int i = 0; i < 5; i++) {
            stack.pop();
        }

        System.out.println("size: " + stack.size());

    }
}
