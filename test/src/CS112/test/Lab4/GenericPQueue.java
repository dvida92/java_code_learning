//package CS112.test.Lab4;
//
///**
// * Created by davidzhou on 6/14/17.
// */
///* File: GenericPQueue.java
// * Date: 6/13/17
// * Author:  Wayne Snyder (snyder@bu.edu)
// * Class: CS 112, Summer I, 2017
// * Purpose: Template for Problem 2 in Lab 4
// */
//
//
//
//public class GenericPQueue<Item extends Comparable<Item>> {
//
//    private class Node {
//        Item item;
//        Node next;
//        public Node(Item it, Node n) {
//            item = it; next = n;
//        }
//    }
//
//
//    // Your code here!  Remember, if you have a declarations
//    //      Item x;
//    //      Item y;
//    // then you can call x.compareTo(y)
//
//
//    public static void main(String [] args) {
//
//        GenericPQueue<Integer> S = new GenericPQueue<Integer>();
//
//        S.insert(3);
//        S.insert(2);
//        S.insert(6);
//
//        System.out.println("\nTest 1: Should print out:\n3");
//        System.out.println(S.size());
//
//
//        System.out.println("\nTest 2: Should print out:\nfalse");
//        System.out.println(S.isEmpty());
//
//        System.out.println("\nTest 3: Should print out:\n6");
//        System.out.println(S.getMax());
//
//        S.insert(4);
//        S.insert(8);
//        S.insert(7);
//        S.insert(1);
//
//        System.out.println("\nTest 4: Should print out:\n8 7 4 3 2 1");
//        while(!S.isEmpty()) {
//            System.out.print(S.getMax() + " ");
//        }
//        System.out.println();
//
//        System.out.println("\nTest 5: Should print out:\ntrue");
//        System.out.println(S.isEmpty());
//
//        GenericPQueue<String> Q = new GenericPQueue<String>();
//
//        Q.insert("hi");
//        Q.insert("there");
//        Q.insert("hithere!");
//
//        System.out.println("\nTest 6: Should print out:\nthere");
//        System.out.println(Q.getMax());
//
//        Q.insert("cs112");
//        Q.insert("is");
//        Q.insert("lots");
//        Q.insert("of");
//        Q.insert("fun");
//
//        System.out.println("\nTest 7: Should print out:\nof lots is hithere! hi fun cs112");
//        while(!Q.isEmpty()) {
//            System.out.print(Q.getMax() + " ");
//        }
//        System.out.println();
//
//        System.out.println("\nTest 8: Should print out:\ntrue");
//        System.out.println(Q.isEmpty());
//
//    }
//
//}
//
//
//
