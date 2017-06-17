package CS112.test.hw3;

/**
 * Created by davidzhou on 6/2/17.
 */
/* File: Set.java
 * Date: 4/31/17
 * Author: Wayne Snyder
 * Class: CS 112, Summer I, 2017
 * Purpose: This is the template for HW 03, Problem B.3, for Sets
 */

public class Set  {

    private int SIZE = 5;  // length of the array

    private int[] S;              // array holding the set

    private int next;             // pointer to next available slot in array


    public Set() {
        // your code here
        S = new int[SIZE];
        next = 0;
    }

    public Set(int[] A) {
        // your code here
        S = new int[SIZE];
        for (int i = 0; i < A.length; i++) {
            insert(A[i]);
        }
    }

    public Set clone() {
        // your code here
        Set copy = new Set();
        for (int i = 0; i < next; i++) {
            copy.insert(S[i]);
        }
        return copy;
    }

    // This method reallocates the array S to twice as big and copies all the elements over.
    // It is called only by insert.

    private void resize() {
        int[] T = new int[SIZE * 2];
        for(int i = 0; i < S.length; ++i) {
            T[i] = S[i];
        }
        SIZE = SIZE * 2;
        S = T;
    }

    public void insert(int k) {
        // your code here
        if (!member(k)) {
            if (next < SIZE) {
                S[next++] = k;
            } else {
                resize();
                S[next++] = k;
            }
        }
    }

    public  String toString()  {
        // your code here
        String s = "[";
        for (int i = 0; i < next - 1; i++) {
            s += S[i] + ",";
        }
        if (next > 0) {
            s += S[next - 1];
        }
        s += "]";
        return s;   // just to get it to compile; replace null with something appropriate
    }

    public int size() {
        return next;
    }

    public  boolean isEmpty() {
        return next == 0;
    }

    public boolean member(int k) {
        for (int i = 0; i < next; i++) {
            if (S[i] == k) return true;

        }
        return false;
    }

    public  boolean subset(Set T) {
        for (int i = 0; i < next; i++) {
            if (!T.member(S[i])) return false;
        }
        return true;
    }

    public  boolean equal(Set T) {
        return subset(T) && T.subset(this);
    }


    public void delete(int k) {
        if (member(k)) {
            int position = -1;
            for (int i = 0; i < S.length; i++) {
                if (S[i] == k) {
                    position = i;
                    break;
                }
            }
            if (position == next - 1) {
                next--;
                return;
            }

            for (int i = position + 1; i < next; i++) {
                S[i - 1] = S[i];

            }
            next--;
        }

    }

    public Set union(Set T) {

        Set ret = clone();
        for (int i = 0; i < T.next; i++) {
            ret.insert(T.S[i]);
        }
        return ret;
    }

    public Set intersection(Set T) {
        Set ret = new Set();
        for (int i = 0; i < next; i++) {
            if (T.member(S[i])) ret.insert(S[i]);
        }
        return ret;
    }

    public Set setdifference(Set T) {
        // your code here
        Set ret = new Set();
        for (int i = 0; i < next; i++) {
            if (!T.member(S[i])) ret.insert(S[i]);
        }


        return ret;
    }

    public static void main(String [] args) {

        System.out.println("\nUnit Test for Set: note that your answers, when they are");
        System.out.println("  sets, could be in a different order (since order does");
        System.out.println("  not matter), this is the meaning of \"same set as...\"\n");

        Set A = new Set();
        Set B = new Set( new int[] { 5 } );
        Set C = new Set( new int[] { 5, 3, 7, 4, 1 } );
        Set D = new Set( new int[] { 4, 3, -3, 10, 8 } );
        Set E = new Set( new int[] { 8, 4, 10 } );
        Set F = new Set( new int[] { 10, 8, 4 } );

        System.out.println("Test 01: Should be\n[]");
        System.out.println(A);
        System.out.println();

        System.out.println("Test 02: Should be\n[5]");
        System.out.println(B);
        System.out.println();

        System.out.println("Test 03: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C);
        System.out.println();

        System.out.println("Test 04: Should be\n[]");
        System.out.println(A.clone());
        System.out.println();

        System.out.println("Test 05: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.clone());
        System.out.println();

        System.out.println("Test 06: Should be\n0");
        System.out.println(A.size());
        System.out.println();

        System.out.println("Test 07: Should be\n5");
        System.out.println(D.size());
        System.out.println();

        System.out.println("Test 08: Should be\ntrue");
        System.out.println(A.isEmpty());
        System.out.println();

        System.out.println("Test 09: Should be\nfalse");
        System.out.println(F.isEmpty());
        System.out.println();

        System.out.println("Test 10: Should be\nfalse");
        System.out.println(A.member(4));
        System.out.println();

        System.out.println("Test 11: Should be\ntrue");
        System.out.println(C.member(1));
        System.out.println();

        System.out.println("Test 12: Should be\nfalse");
        System.out.println(D.member(1));
        System.out.println();

        System.out.println("Test 13: Should be\ntrue");
        System.out.println(A.subset(D));
        System.out.println();

        System.out.println("Test 14: Should be\nfalse");
        System.out.println(D.subset(C));
        System.out.println();

        System.out.println("Test 15: Should be\ntrue");
        System.out.println(E.subset(D));
        System.out.println();

        System.out.println("Test 16: Should be\nfalse");
        System.out.println(D.subset(E));
        System.out.println();

        System.out.println("Test 17: Should be\nfalse");
        System.out.println(D.equal(E));
        System.out.println();

        System.out.println("Test 18: Should be\ntrue");
        System.out.println(E.equal(F));
        System.out.println();

        System.out.println("Test 19: Should be\ntrue");
        System.out.println(F.equal(E));
        System.out.println();

        System.out.println("Test 20: Should be\ntrue");
        System.out.println(A.equal(A));
        System.out.println();

        System.out.println("Test 21: Should be same set as\n[4,6]");
        Set A1 = A.clone();
        A1.insert(4);
        A1.insert(6);
        A1.insert(4);
        System.out.println(A1);
        System.out.println();

        System.out.println("Test 22: Should be same set as\n[10,8,4,5]");
        Set F1 = F.clone();
        F1.insert(5);
        F1.insert(4);
        System.out.println(F1);
        System.out.println();

        System.out.println("Test 23: Should be same set as\n[8,4,10]");
        Set E1 = E.clone();
        E1.insert(10);
        System.out.println(E1);
        System.out.println();

        System.out.println("Test 24: Should be\n[]");
        A1 = A.clone();
        A1.delete(5);
        System.out.println(A1);
        System.out.println();

        System.out.println("Test 25: Should be\n[]");
        Set B1 = B.clone();
        B1.delete(5);
        System.out.println(B1);
        System.out.println();

        System.out.println("Test 26: Should be same set as\n[8,4,10]");
        E1 = E.clone();
        E1.delete(5);
        System.out.println(E1);
        System.out.println();

        System.out.println("Test 27: Should be same set as\n[4,10]");
        E1 = E.clone();
        E1.delete(8);
        System.out.println(E1);
        System.out.println();

        System.out.println("Test 28: Should be same set as\n[3,4]");
        System.out.println(C.intersection(D));
        System.out.println();

        System.out.println("Test 29: Should be\n[8,4,10]");
        System.out.println(E.intersection(F));
        System.out.println();

        System.out.println("Test 30: Should be same set as\n[]");
        System.out.println(A.intersection(F));
        System.out.println();

        System.out.println("Test 31: Should be same set as\n[]");
        System.out.println(B.intersection(F));
        System.out.println();

        System.out.println("Test 32: Should be same set as\n[4,3,-3,10,8,5,7,1]");
        System.out.println(C.union(D));
        System.out.println();

        System.out.println("Test 33: Should be same set as\n[10,8,4]");
        System.out.println(E.union(F));
        System.out.println();

        System.out.println("Test 34: Should be same set as\n[10,8,4]");
        System.out.println(A.union(F));
        System.out.println();

        System.out.println("Test 35: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.union(B));
        System.out.println();

        System.out.println("Test 36: Should be same set as\n[5,7,1]");
        System.out.println(C.setdifference(D));
        System.out.println();

        System.out.println("Test 37: Should be same set as\n[]");
        System.out.println(E.setdifference(F));
        System.out.println();

        System.out.println("Test 38: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.setdifference(A));
        System.out.println();

        System.out.println("Test 39: Should be same set as\n[]");
        System.out.println(C.setdifference(C));
        System.out.println();

        System.out.println("Test 40: Should be same set as\n[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]");
        Set G = new Set();
        for(int i = 0; i < 32; ++i) {
            G.insert(i);
        }
        System.out.println(G);
        System.out.println();

    }
}
