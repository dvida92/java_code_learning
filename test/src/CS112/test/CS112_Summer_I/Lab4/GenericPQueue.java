package CS112.test.CS112_Summer_I.Lab4;

/**
 * Created by davidzhou on 6/14/17.
 */
/* File: GenericPQueue.java
 * Date: 6/13/17
 * Author:  Wayne Snyder (snyder@bu.edu)
 * Class: CS 112, Summer I, 2017
 * Purpose: Template for Problem 2 in Lab 4
 */



public class GenericPQueue<Item extends Comparable<Item>> {

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
    public void insert(Item k) {
        head = insertInOrder(k, head);
        ++size;
    }

    //Insert k, and then return the head of the new linked list
    private Node insertInOrder(Item k, Node p) {
        if(p == null) {
            return new Node(k,null);
        }
        else if(k.compareTo(p.item) > 0) {
            return new Node(k,p);
        }
        else {
            p.next = insertInOrder(k,p.next);
            return p;
        }
    }

    // remove element from top of stack: can underflow!
    public Item getMax() {
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

        GenericPQueue<Integer> S = new GenericPQueue<Integer>();

        S.insert(3);
        S.insert(2);
        S.insert(6);

        System.out.println("\nTest 1: Should print out:\n3");
        System.out.println(S.size());


        System.out.println("\nTest 2: Should print out:\nfalse");
        System.out.println(S.isEmpty());

        System.out.println("\nTest 3: Should print out:\n6");
        System.out.println(S.getMax());

        S.insert(4);
        S.insert(8);
        S.insert(7);
        S.insert(1);

        System.out.println("\nTest 4: Should print out:\n8 7 4 3 2 1");
        while(!S.isEmpty()) {
            System.out.print(S.getMax() + " ");
        }
        System.out.println();

        System.out.println("\nTest 5: Should print out:\ntrue");
        System.out.println(S.isEmpty());

        GenericPQueue<String> Q = new GenericPQueue<String>();

        Q.insert("hi");
        Q.insert("there");
        Q.insert("hithere!");

        System.out.println("\nTest 6: Should print out:\nthere");
        System.out.println(Q.getMax());

        Q.insert("cs112");
        Q.insert("is");
        Q.insert("lots");
        Q.insert("of");
        Q.insert("fun");

        System.out.println("\nTest 7: Should print out:\nof lots is hithere! hi fun cs112");
        while(!Q.isEmpty()) {
            System.out.print(Q.getMax() + " ");
        }
        System.out.println();

        System.out.println("\nTest 8: Should print out:\ntrue");
        System.out.println(Q.isEmpty());

    }

}

