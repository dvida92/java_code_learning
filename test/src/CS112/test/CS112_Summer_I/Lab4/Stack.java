package CS112.test.CS112_Summer_I.Lab4;

/**
 * Created by davidzhou on 6/14/17.
 */

/* File: Stack.java
 * Date: 6/13/17
 * Author:  Wayne Snyder (snyder@bu.edu)
 * Class: CS 112, Summer I, 2017
 * Purpose: Example of integer stack implemented by a linked list.
 *          This will be rewritten in two ways, to create a generic stack,
 *          and a generic priority queue.
 */



public class Stack {

    private class Node {
        int item;
        Node next;
        public Node(int it, Node n) {
            item = it; next = n;
        }
    }

    private int size = 0;                      // number of elements stored in queue
    private Node head = null;                  // head is top of queue

    // insert at top
    public void push(int k) {
        head = new Node(k, head);
        ++size;
    }

    // remove element from top of stack: can underflow!
    public int pop() {
        int temp = head.item;
        head = head.next;
        --size;
        return temp;
    }

    // just a wrapper for private value size
    public int size() {
        return size;
    }

    // standard utility for data structures
    private boolean isEmpty() {
        return (size == 0);
    }

    // for debugging....


    public static void main(String [] args) {

        Stack S = new Stack();

        S.push(3);
        S.push(2);
        S.push(6);

        System.out.println("\nTest 1: Should print out:\n3");
        System.out.println(S.size());


        System.out.println("\nTest 2: Should print out:\nfalse");
        System.out.println(S.isEmpty());

        System.out.println("\nTest 3: Should print out:\n6");
        System.out.println(S.pop());

        S.push(4);
        S.push(8);
        S.push(7);
        S.push(1);

        System.out.println("\nTest 4: Should print out:\n1 7 8 4 2 3");
        while(!S.isEmpty()) {
            System.out.print(S.pop() + " ");
        }
        System.out.println();

        System.out.println("\nTest 5: Should print out:\ntrue");
        System.out.println(S.isEmpty());


    }

}

