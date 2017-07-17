package CS112.test.CS112_Summer_I.hw4;

/**
 * B.4
 * Created by davidzhou on 6/10/17.
 */
/*
 * File: LinkedListPractice.java
 * Author: Wayne Snyder
 * Date: June 9th, 2017
 * Purpose: This is the template for HW 04 B, Problem 4.
 */

public class LinkedListPractice {

    // Node class for the linked list
    private static class Node {

        int item;
        Node next;

        public Node() {
            item = 0;
            next = null;
        }

        public Node(int n) {
            item = n;
            next = null;
        }

        public Node(int n, Node p) {
            item = n;
            next = p;
        }
    }



    // Return the length of the list
    private static int length(Node h) {
        int counter = 0;
        for (Node i = h; i != null; i = i.next) {
            counter ++;
        }
        return counter;
    }


    // Count the number of odd numbers in the list
    private static int numOdd(Node h) {
        if (h == null) return 0;
        int counter = 0;
        for (Node i = h; i != null ; i = i.next) {
            if (i.item % 2 != 0) counter++;
        }
        return counter;      // just to get it to compile
    }

    // Return the average of the numbers in the list,
    // or -1 if list is empty; you may use ONLY a single loop
    private static double avg(Node h) {
        if (h == null) return -1;
        double sum = 0;
        int counter = 0;
        for (Node i = h; i != null ; i = i.next) {
            sum += i.item;
            counter++;
        }
        return sum / counter;
    }

    // Return the nth integer in the list, where first item in list is at position 0
    // (as if it were an array); return -1 is n >= length of list
    private static int nth(int n, Node h) {
        if (length(h) <= n) return -1;
        Node p = h;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        return p.item;
    }


    // Return true if list is in ascending order (each number is strictly greater than
    // the one before it; an empty list or a list with only one number is considered to
    // be in ascending order.
    private static boolean inAscendingOrder(Node h) {
        if (h == null) return true;
        for (Node i = h; i.next != null; i = i.next) {
            if (i.item >= i.next.item) return false;
        }
        return true;
    }

    // Return true if the two lists are equal (same numbers in same order)
    // and false otherwise
    private static boolean equal(Node h1, Node h2) {
        if (h1 == null && h2 == null) return true;
        if (h1 == null) return false;
        if (h2 == null) return false;

        if (length(h1) != length(h2)) return false;
        Node p1 = h1;
        Node p2 = h2;
        while (p1 != null && p2 != null) {
            if (p1.item != p2.item) return false;
            else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return true;
    }

    // Make an exact copy of a list
    private static Node copy(Node h) {
        // Your code here
        if (h == null) return null;

        Node head = new Node(h.item);
        Node p = head;
        for (Node q = h.next; q != null; q = q.next) {
            p.next = new Node(q.item);
            p = p.next;
        }

        return head;
    }


    private static void printList(Node h) {
        System.out.print("-> ");
        for (Node p = h; p != null; p = p.next) {
            System.out.print(p.item + " -> ");
        }
        System.out.println(".");
    }

    public static void main(String[] args) {
        Node[] head = new Node[7];
        head[0] = null;
        head[1] = new Node(5);
        head[2] = new Node(3, new Node(1, new Node(4, new Node(1))));
        head[3] = new Node(6, new Node(1, new Node(9)));
        head[4] = new Node(6, new Node(1, new Node(9)));
        head[5] = new Node(3, new Node(6, new Node(9, new Node(12))));
        head[6] = new Node(6, new Node(6));
        for (int i = 0; i < 7; ++i) {
            System.out.print("head" + i + " ");
            printList(head[i]);
        }



        System.out.println("\nTest 1: Should print out\n0 ");
        System.out.println(length(head[0]));

        System.out.println("\nTest 2: Should print out\n1 ");
        System.out.println(length(head[1]));

        System.out.println("\nTest 3: Should print out\n4 ");
        System.out.println(length(head[2]));

        System.out.println("\nTest 4: Should print out\n0 ");
        System.out.println(numOdd(head[0]));

        System.out.println("\nTest 5: Should print out\n1 ");
        System.out.println(numOdd(head[1]));

        System.out.println("\nTest 6: Should print out\n3 ");
        System.out.println(numOdd(head[2]));

        System.out.println("\nTest 7: Should print out\n0 ");
        System.out.println(numOdd(head[6]));

        System.out.println("\nTest 8: Should print out\n-1.0 ");
        System.out.println(avg(head[0]));

        System.out.println("\nTest 9: Should print out\n5.0 ");
        System.out.println(avg(head[1]));

        System.out.println("\nTest 10: Should print out\n2.25 ");
        System.out.println(avg(head[2]));

        System.out.println("\nTest 11: Should print out\n-1 ");
        System.out.println(nth(2, head[0]));

        System.out.println("\nTest 12: Should print out\n5 ");
        System.out.println(nth(0, head[1]));

        System.out.println("\nTest 13: Should print out\n-1 ");
        System.out.println(nth(2, head[0]));

        System.out.println("\nTest 14: Should print out\n3 ");
        System.out.println(nth(0, head[2]));

        System.out.println("\nTest 15: Should print out\n12 ");
        System.out.println(nth(3, head[5]));

        System.out.println("\nTest 16: Should print out\n-1 ");
        System.out.println(nth(4, head[5]));

        System.out.println("\nTest 17: Should print out\ntrue ");
        System.out.println(inAscendingOrder(head[0]));

        System.out.println("\nTest 18: Should print out\ntrue ");
        System.out.println(inAscendingOrder(head[1]));

        System.out.println("\nTest 19: Should print out\nfalse ");
        System.out.println(inAscendingOrder(head[3]));

        System.out.println("\nTest 20: Should print out\ntrue ");
        System.out.println(inAscendingOrder(head[5]));

        System.out.println("\nTest 21: Should print out\nfalse ");
        System.out.println(inAscendingOrder(head[6]));

        System.out.println("\nTest 22: Should print out\ntrue ");
        System.out.println(equal(head[0], head[0]));

        System.out.println("\nTest 23: Should print out\nfalse ");
        System.out.println(equal(head[1], head[0]));

        System.out.println("\nTest 24: Should print out\nfalse ");
        System.out.println(equal(head[0], head[3]));

        System.out.println("\nTest 25: Should print out\ntrue ");
        System.out.println(equal(head[5], head[5]));

        System.out.println("\nTest 26: Should print out\nfalse ");
        System.out.println(equal(head[5], head[6]));

        System.out.println("\nTest 27: Should print out\ntrue ");
        System.out.println(equal(head[4], head[3]));

        System.out.println("\nTest 28: Should print out\n-> . ");
        printList(copy(head[0]));

        System.out.println("\nTest 29: Should print out\n-> 5 -> . ");
        printList(copy(head[1]));

        System.out.println("\nTest 30: Should print out\n-> 3 -> 1 -> 11 -> 1 -> . ");
        Node temp = copy(head[2]);
        if(temp != null) {                 // just to get it compile
            temp.next.next.item = 11;
        }
        printList(temp);

        System.out.println("\nTest 25: Should print out\n-> 3 -> 1 -> 4 -> 1 -> . ");
        printList(head[2]);

    }

}