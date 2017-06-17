package CS112.test.Lab4;

/**
 * Created by davidzhou on 6/14/17.
 */

/* File: GenericStack.java
 * Date: 6/13/17
 * Author:  Wayne Snyder (snyder@bu.edu)
 * Class: CS 112, Summer I, 2017
 * Purpose: This is the template for Problem 1 in Lab 4.
 */


public class GenericStack<Item> {

    // Rewrite the Stack code to use the Item type instead of ints.
    private class Node {
        Item item;
        Node next;
        public Node(Item it, Node n) {
            item = it; next = n;
        }
    }

    private int size = 0;                      // number of elements stored in queue
    private Node head = null;                  // head is top of queue

    // insert at top
    public void push(Item k) {
        head = new Node(k, head);
        ++size;
    }

    // remove element from top of stack: can underflow!
    public Item pop() {
        Item temp = head.item;
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

    public static void main(String [] args) {

        GenericStack<Integer> S = new GenericStack<Integer>();

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

        GenericStack<String> Q = new GenericStack<String>();

        Q.push("hi");
        Q.push("there");
        Q.push("hithere!");

        System.out.println("\nTest 6: Should print out:\nhithere!");
        System.out.println(Q.pop());

        Q.push("cs112");
        Q.push("is");
        Q.push("lots");
        Q.push("of");
        Q.push("fun");

        System.out.println("\nTest 7: Should print out:\nfun of lots is cs112 there hi");
        while(!Q.isEmpty()) {
            System.out.print(Q.pop() + " ");
        }
        System.out.println();

        System.out.println("\nTest 8: Should print out:\ntrue");
        System.out.println(Q.isEmpty());


    }

}

