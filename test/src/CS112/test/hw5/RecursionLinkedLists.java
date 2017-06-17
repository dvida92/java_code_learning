package CS112.test.hw5;

/**
 * Created by davidzhou on 6/17/17.
 */
/* File: RecursionLinkedLists.java
 * Author: Wayne Snyder (waysnyder@gmail.com)
 * Date:6/16/17
 * Purpose: This is the template for Problem 2 in HW 05 in CS 112, Summer I, 2017.
 */

public class RecursionLinkedLists {

    public static class Node {
        int item;
        Node next;
        public Node(int it, Node n) {
            item = it; next = n;
        }
        public String toString() {
            if (this.next == null) {
                return " -> " + this.item + " -> .";
            }
            else {
                return " -> " + this.item + next;
            }
        }
    }

    // utility method from notes on linked lists and recursion, if needed

    public static Node copy( Node p ) {
        if( p == null )
            return null;
        else
            return new Node(p.item, copy( p.next ));
    }


    // Problem B.2.A

    public static Node arrayToLinkedList(int[] A) {
        return arrayToLinkedListUtil(A, 0);
    }

    public static Node arrayToLinkedListUtil(int[] A, int i) {
        if (i == A.length) {
            return null;
        }
        return new Node(A[i], arrayToLinkedListUtil(A, i + 1));
    }


    // Problem B.2.B

    public static int count(int n, Node p) {
        if (p == null) return 0;
        if (p.item == n) return 1 + count(n, p.next);
        else return count(n, p.next);
    }

    // Problem B.2.C

    public static double mean(Node p) {
        // your code here
        return 0.0;   // just to get it to compile
    }

    // Problem B.2.D

    public static Node deleteNth(Node p, int n ) {
        // your code here
        return null;   // just to get it to compile
    }


    // Problem B.2.E

    public static Node everyOther(Node p) {
        // your code here
        return null;   // just to get it to compile
    }

    // Problem B.2.F

    public static boolean equalLists(Node p,Node q) {
        // your code here
        return false;   // just to get it to compile
    }

    // Problem B.2.G

    public static boolean prefix(Node p, Node q)  {
        // your code here
        return false;   // just to get it to compile
    }

    // Problem B.2.H

    public static boolean sublist(Node p, Node q)  {
        // your code here
        return false;   // just to get it to compile
    }


    // Problem B.2.I

    public static Node splice(int n, Node p, Node q)  {
        // your code here
        return null;   // just to get it to compile
    }


    // Problem B.2.J

    public static Node intersection(Node p,Node q) {
        // your code here
        return null;   // just to get it to compile
    }



    public static void main(String [] args) {

        Node head = new Node(3, new Node(6, new Node( 9, new Node(12, null ) ) ) );

        // Sample tests just to show how toString() prints out lists (note that empty lists are null,
        // so there is no toString() to call on a null pointer, and it just prints "null")

        System.out.println("\nTest x:  should print out:\n -> 3 -> 6 -> 9 -> 12 -> .");
        System.out.println(head);

        head = null;
        System.out.println("\nTest xx:  should print out:\nnull");
        System.out.println(head);

        // your tests here

    }

}


