package CS112.test.CS112_Summer_I.hw5;

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

    /**
     *
     * @param A
     * @param i
     * @return A Linked List with the elements starting from index i
     */
    private static Node arrayToLinkedListUtil(int[] A, int i) {
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
        return mean(p, 0, 0);
    }

    private static double mean(Node p, double sum, int n) {
        if (p == null) return sum / n;
        return mean(p.next, sum + p.item, n + 1);
    }

    // Problem B.2.D

    public static Node deleteNth(Node p, int n ) {
        if (n >= length(p)) return p; // Should be > ?
        if (n == 0) return p.next;
        else {
            p.next = deleteNth(p.next, n - 1);
            return p;
        }
    }

    public static int length(Node p) {
        if (p == null) return 0;
        return 1 + length(p.next);
    }


    // Problem B.2.E

    public static Node everyOther(Node p) {
        return everyOtherUtil(p, 0);
    }

    private static Node everyOtherUtil(Node p, int n) {
        if (p == null) return null;
        if (n % 2 == 0) {
            p.next = everyOtherUtil(p.next, n + 1);
            return p;
        }
        return everyOtherUtil(p.next, n + 1);

    }

    // Problem B.2.F

    public static boolean equalLists(Node p,Node q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.item == q.item) return equalLists(p.next, q.next);
        return false;
    }

    // Problem B.2.G
    // Test if p is a prefix of q
    public static boolean prefix(Node p, Node q)  {
        if (p == null && q == null) return true;
        if (p == null) return true;
        if (q == null) return false;

        if (p.item == q.item) return prefix(p.next, q.next);
        return false;
    }

    // Problem B.2.H
    // Test if p is a contiguous sublist of q
    public static boolean sublist(Node p, Node q)  {
        if (prefix(p, q)) return true;
        return prefix(p, q.next);
    }


    // Problem B.2.I
    // Insert q into p

    /**
     *
     * @param n before nth node in p
     * @param p LLS
     * @param q LLS: to be inserted into p
     * @return
     */
    public static Node splice(int n, Node p, Node q) {
        if (q == null) return p;
        if (p == null) return q;
        if (n == 0) {
            q.next = splice(0, p, q.next);
            return q;
        } else {
            p.next = splice(n - 1, p.next, q);
            return p;
        }
    }


    // Problem B.2.J

    /**
     * Iterative Algorithm
     * @param p Sorted LLS
     * @param q Sorted LLS
     * @return The intersection of p and q
     */
    public static Node intersection(Node p,Node q) {
        Node dummyHead = new Node(0, null);
        Node p1 = p;
        Node q1 = q;
        Node ret = dummyHead;

        while (p1 != null && q1 != null) {
            if (p1.item == q1.item) {
                ret.next = new Node(p1.item, null);
                ret = ret.next;
                p1 = p1.next;
                q1 = q1.next;
            } else if (p1.item < q1.item) {
                p1 = p1.next;
            } else {
                q1 = q1.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * Recursive Algorithm for Intersection
     * @param p
     * @param q
     * @return
     */
    public static Node intersection2(Node p, Node q) {
        if (p == null || q == null) return null;
        if (p.item == q.item) {
            return new Node(p.item, intersection2(p.next, q.next));
        }
        if (p.item < q.item) {
            return intersection2(p.next, q);
        } else {
            return intersection2(p, q.next);
        }
    }




    public static void main(String [] args) {

        Node head = new Node(3, new Node(6, new Node( 9, new Node(12, null ) ) ) );

        System.out.println("First test the clever recursive toString inside the Node class....");

        System.out.println("\nTest 00a:  should print out:\n -> 3 -> 6 -> 9 -> 12 -> .");
        System.out.println(head);
        head = null;
        System.out.println("\nTest 00b:  should print out:\nnull");
        System.out.println(head);

        System.out.println("\nTest 01 arrayToLinkedList:  should print out:\n -> 2 -> 5 -> 4 -> .");
        int[] A = {2,5,4};
        System.out.println(arrayToLinkedList(A));

        System.out.println("\nTest 02 arrayToLinkedList:  should print out:\nnull");
        int[] B = {};
        System.out.println(arrayToLinkedList(B));

        int[] C = {2,5,4,6,2,9};
        Node headC = arrayToLinkedList(C);
        System.out.println("\nTest 03  deleteNth:  should print out:\n2 -> 5 -> 6 -> 2 -> 9 -> .");
        System.out.println(deleteNth(copy(headC),3));

        System.out.println("\nTest 04  deleteNth:  should print out:\n5 -> 4 -> 6 -> 2 -> 9 -> .");
        System.out.println(deleteNth(copy(headC),1));

        System.out.println("\nTest 05deleteNth:  should print out:\n2 -> 5 -> 4 -> 6 -> 2 -> 9 -> .");
        System.out.println(deleteNth(copy(headC),13));

        System.out.println("\nTest 06] deleteNth:  should print out:\nnull");
        System.out.println(deleteNth(null,3));

        int[] D = {4,5,7,2,6,9};
        int[] E = {4,5,7,6,9};
        int[] F = {4,5,2,6,9};
        Node headD = arrayToLinkedList(D);
        Node headE = arrayToLinkedList(E);
        Node headF = arrayToLinkedList(F);
        System.out.println("\nTest 07equalLists:  should print out:\ntrue");
        System.out.println(equalLists(headD,headD));

        System.out.println("\nTest 08equalLists:  should print out:\nfalse");
        System.out.println(equalLists(headE,headD));

        System.out.println("\nTest 08] equalLists:  should print out:\nfalse");
        System.out.println(equalLists(headF,headE));

        int[] G = {4,5,7};
        int[] H = {4,5,7,2,8,1};
        Node headG = arrayToLinkedList(G);
        Node headH = arrayToLinkedList(H);
        System.out.println("\nTest 09everyOther:  should print out:\nnull");
        System.out.println(everyOther(null));

        System.out.println("\nTest 010] everyOther:  should print out:\n4 -> 7 -> .");
        System.out.println(everyOther(copy(headG)));

        System.out.println("\nTest 011everyOther:  should print out:\n4 -> 7 -> 8 -> .");
        System.out.println(everyOther(copy(headH)));

        System.out.println("\nTest 012equalListsRec:  should print out:\ntrue");
        System.out.println(equalLists(headD,headD));

        System.out.println("\nTest 013equalListsRec:  should print out:\nfalse");
        System.out.println(equalLists(headE,headD));

        System.out.println("\nTest 014equalListsRec:  should print out:\nfalse");
        System.out.println(equalLists(headF,headE));


        System.out.println("\nTest 015everyOtherRec:  should print out:\nnull");
        System.out.println(everyOther(null));

        System.out.println("\nTest 016everyOtherRec:  should print out:\n4 -> 7 -> .");
        System.out.println(everyOther(headG));

        System.out.println("\nTest 017everyOtherRec:  should print out:\n4 -> 7 -> 8 -> .");
        System.out.println(everyOther(headH));

        int[] I = {1,2,3};
        int[] J = {5,6,7};
        Node headI = arrayToLinkedList(I);
        Node headJ = arrayToLinkedList(J);

        System.out.println("\nTest 018splice:  should print out:\n1 -> 5 -> 6 -> 7 -> 2 -> 3 -> .");
        System.out.println(splice(1,copy(headI),copy(headJ)));

        System.out.println("\nTest 019splice:  should print out:\n1 -> 2 -> 3 -> 5 -> 6 -> 7 -> .");
        System.out.println(splice(3,copy(headI),copy(headJ)));

        System.out.println("\nTest 020splice:  should print out:\n5 -> 6 -> 7 -> 1 -> 2 -> 3 -> .");
        System.out.println(splice(0,copy(headI),copy(headJ)));

        System.out.println("\nTest 021splice:  should print out:\n1 -> 2 -> 3 -> 5 -> 6 -> 7 -> .");
        System.out.println(splice(10,copy(headI),copy(headJ)));

    }

}


