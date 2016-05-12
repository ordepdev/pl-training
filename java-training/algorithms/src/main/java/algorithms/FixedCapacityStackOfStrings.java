package algorithms;

public class FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() { return N == 0; }
    public boolean isFull() { return a.length == N; }
    public int size() { return N; }

    public void push(String item) {
        if (!isFull()) a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {

        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(3);

        for (int i = 0; i < 3; i++) {
            stack.push(String.valueOf(i));
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }

    }
}
