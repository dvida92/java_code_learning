package CS112.test.Lab3_Solution;



public class Queue extends Collection {

    protected int next;

    public Queue() {
        next = 0;
    }

    protected void resize() {
        SIZE = SIZE * 2;
        int[] B = new int[SIZE];
        for(int i = 0; i < SIZE; ++i) {
            B[i] = A[i];
        }
        A = B;
    }

    // same as enqueue
    public void insert(int n) {
        if(size() == SIZE) {
            resize();
        }
        A[next++] = n;
    }

    // same as dequeue
    public int remove() {
        int temp = A[0];
        for(int i = 0; i < next - 1; i++) {
            A[i] = A[i+1];
        }

        --next;
        return temp;
    }

    public int peek() {
        return A[0];
    }

    public int size() {
        return next;
    }

    public String toString() {
        String s = "< ";
        for(int i = 0; i < next; ++i) {
            s += A[i] + " ";
        }

        return s + "<";
    }

    public static void main(String[] args) {
        Queue S = new Queue();
        System.out.println("\nTest 1: Should be:\n0");
        System.out.println(S.size());

        System.out.println("\nTest 2: Should be:\ntrue");
        System.out.println(S.isEmpty());

        S.insert(4);
        S.insert(8);
        S.insert(2);

        System.out.println("\nTest 3: Should be:\n< 4 8 2 <");
        System.out.println(S);

        System.out.println("\nTest 4: Should be:\n4");
        System.out.println(S.peek());

        System.out.println("\nTest 5: Should be:\n8");
        System.out.println(S.remove());     // value will be thrown away
        System.out.println(S.remove());
        S.insert(5);

        System.out.println("\nTest 6: Should be:\n< 2 5 <");
        System.out.println(S);

        System.out.println("\nTest 7: Should be:\n2");
        System.out.println(S.size());

        System.out.println("\nTest 8: Should be:\nfalse");
        System.out.println(S.isEmpty());

        System.out.println("\nTest 9: Should be:\n2 5");
        while(!S.isEmpty()) {
            System.out.print(S.remove() + " ");
        }
        System.out.println();


    }

}

