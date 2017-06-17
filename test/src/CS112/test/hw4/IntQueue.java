package CS112.test.hw4;

/** File: IntQueue.java
 * Date: 9/30/16
 * Class: Boston University CS 112, Fall, 2016
 * Author: Wayne Snyder (waysnyder@gmail.com)
 * Purpose: Template for solution to Homework 04, Problem B.2
 **/

public class IntQueue implements Queueable {

    private AnotherStack inStack;
    private AnotherStack outStack;

    public IntQueue() {
        inStack = new AnotherStack();
        outStack = new AnotherStack();
    }

    // Insert a new element on the rear of the queue
    // If stack is full, resizes

    public void enqueue(int n) {
        inStack.push(n);
    }

    // Remove and return the front element of the queue; move everything over to the left one slot
    // Note: Does not check for underflow

    public int dequeue() {
        if (outStack.size() == 0) {
            int inStackLength = inStack.size();
            for (int i = 0; i < inStackLength; i++) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    // Return front element of the queue without removing it
    // Note: Does not check for underflow

    public int peek() {
        if (outStack.size() == 0) {
            int inStackLength = inStack.size();
            for (int i = 0; i < inStackLength; i++) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    // Return the number of integers in the queue

    public int size() {

        return inStack.size() + outStack.size();
    }

    // Return true iff there are no elements in the queue

    public boolean isEmpty() {

        return inStack.isEmpty() && outStack.isEmpty();
    }


    public String toString() {
        String s = "";
        int length = size();
        for (int i = 0; i < length; i++) {
            int tmp = dequeue();
            s = tmp + "\t" + s;
            enqueue(tmp);
        }

        return s;
    }



    // unit test

    public static void main(String [] args) {

        Queueable Q = new IntQueue();

        System.out.println("Unit Test for IntQueue");

        System.out.println("\n[1] Should be:\n0\ttrue");
        System.out.println(Q.size() + "\t" + Q.isEmpty());

        System.out.println("\n[2] Should be:\n4\tfalse");

        Q.enqueue(3);
        Q.enqueue(5);
        Q.enqueue(9);
        Q.enqueue(7);

        System.out.println(Q.size() + "\t" + Q.isEmpty());

        System.out.println("\n[3] Should be:\n7\t9\t5\t3\t (front of queue is to right)");
        System.out.println(Q);

        System.out.println("\n[4] Should be:\n3\t3");
        System.out.print(Q.dequeue());
        System.out.println("\t" + Q.size());


        System.out.println("\n[5] Should be:\n5\t3");
        System.out.print(Q.peek());
        System.out.println("\t" + Q.size());

        Q.enqueue(Q.dequeue());
        System.out.println("\n[6] Should be:\n5\t7\t9");
        System.out.println(Q);

        System.out.println("\nTesting resizing...");
        System.out.println("\n[7] Should be:\n25\t24\t23\t22\t21\t20");

        for(int i = 10; i <= 25; ++i) {
            Q.enqueue(i);
        }

        for(int i = 0; i < 13; ++i) {
            Q.dequeue();
        }

        System.out.println(Q);

    }

}


