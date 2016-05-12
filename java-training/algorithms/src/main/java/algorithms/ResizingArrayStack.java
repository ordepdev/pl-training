package algorithms;

import java.util.Iterator;

// This algorithm is a generic and iterable implementation of
// the Stack API that resizes the array, allows clients to make
// stacks for any type of data, and supports client use of foreach
// to iterate through the stack items in LIFO order.

public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] a = (T[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    private void resize(int size) {
        T[] tmp  = (T[]) new Object[size];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    public void push(T item) {
        if (a.length == N) resize(a.length * 2);
        a[N++] = item;
    }

    public T pop() {
        T item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length/4) resize(a.length / 2);
        return item;
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public T next() { return a[--i]; }
        public void remove() {}
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println(stack.size());

        for (int i = 0; i < 5; i++) {
            stack.pop();
        }

        System.out.println(stack.size());
    }
}
