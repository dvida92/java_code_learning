package CS112.test.CS112_Summer_I.Lab3_Solution;



public class PQueue extends Queue {

    public PQueue() {
        super();  //1. Invokes its superclass constructor
    }

    // same as enqueue
    public void insert(int n) {
        if (size() == SIZE) {
            resize();
        }
        // put new int at end of queue
        A[next++] = n;
        // now swap until it is in the correct position
        for (int i = next - 1; i > 0 && A[i] > A[i - 1]; --i) {
            int temp = A[i];
            A[i] = A[i - 1];
            A[i - 1] = temp;
        }
    }



    public static void main(String[] args) {
        PQueue S = new PQueue();
        System.out.println("\nTest 1: Should be:\n0");
        System.out.println(S.size());

        System.out.println("\nTest 2: Should be:\ntrue");
        System.out.println(S.isEmpty());

        S.insert(4);
        S.insert(8);
        S.insert(2);

        System.out.println("\nTest 3: Should be:\n< 8 4 2 <");
        System.out.println(S);

        System.out.println("\nTest 4: Should be:\n8");
        System.out.println(S.peek());

        System.out.println("\nTest 5: Should be:\n4");
        S.remove(); // value will be thrown away
        System.out.println(S.remove());
        S.insert(5);

        System.out.println("\nTest 6: Should be:\n< 5 2 <");
        System.out.println(S);

        System.out.println("\nTest 7: Should be:\n2");
        System.out.println(S.size());

        System.out.println("\nTest 8: Should be:\nfalse");
        System.out.println(S.isEmpty());

        System.out.println("\nTest 9: Should be:\n5 2");
        while (!S.isEmpty()) {
            System.out.print(S.remove() + " ");
        }
        System.out.println();

    }

}


