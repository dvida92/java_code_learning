package CS112.test.CS112_Summer_I.hw5;

/**
 * Created by davidzhou on 6/17/17.
 */
/* File: SymbolTable.java
 * Author: David Zhouy
 * Date: 6/16/2017
 * Purpose: This is the template for HW 05, containing only the unit test and Node definition
 */

import java.util.*;


//public class SymbolTable<Value> {

    /*  Once you have implemented all the methods, change the first line to this to make sure you have
        implemented everything properly: */

public class SymbolTable<Value> implements Dictionary<Value>, Iterable<String> {


    // basic definition of the Node class; this is an "inner class" inside class SymbolTable

    private class Node {                 // Node class for LLs
        String variable;
        Value value;
        Node next;

        public Node() {}

        public Node(String k, Value v) {
            variable = k; value = v; next = null;
        }

        public Node(String k, Value v, Node p) {
            variable = k; value = v; next = p;
        }
    }

    // pointer to list of bindings for symbol table

    private Node head = null;
    private int size = 0;


    // Your code here!!


    //TODO: Implement Dictionary's method

  /*
   * If the variable var is not in the symbol table, insert a new node containing var and val into
   * the linked list in ascending order (do NOT sort the list, but insert in order of the variable
   * field); if var is already in the table, then simply replace the existing value with the new
   * value val. The type Value is a generic type.
   */

    public void put(String var, Value val) {
        if (contains(var)) {
            findPosition(var, head).value = val;
        } else {
            head = insertInPosition(var, val, head);
            size++;
        }
    }

    /**
     * Return the node that contains "var"
     * @param var
     * @param p
     * @return
     */
    private Node findPosition(String var, Node p) {
        if (p.variable.equals(var)) return p;
        return findPosition(var, p.next);
    }


    /**
     * Insert value pair to LLs p and main ascending lexicographic order
     * @param var
     * @param val
     * @param p
     * @return
     */
    private Node insertInPosition(String var, Value val, Node p) {
        if (p == null) return new Node(var, val, null);
        if (var.compareTo(p.variable) < 0) {
            return new Node(var, val, p);
        }

        p.next = insertInPosition(var, val, p.next);
        return p;
    }

  /*
   * Return the value associated with the variable var, or return null if var is not in the table.
   */

    public Value get(String var) throws KeyNotFoundException{
        if (!contains(var)) throw new KeyNotFoundException();
        return getUtil(var, head);
    }

    private Value getUtil(String var, Node p) {
        if (p == null) return null;  //Redundancy
        if (p.variable.equals(var)) return p.value;
        return getUtil(var, p.next);
    }

  /*
   * Return true or false, depending on whether var is in the table or not.
   */

    public boolean contains(String var) {
        return containsUtil(var, head);
    }

    private boolean containsUtil(String var, Node p) {
        if (p == null) return false;
        if (p.variable.equals(var)) return true;
        return containsUtil(var, p.next);
    }

  /*
   * Remove the node containing var from the table; if var is not in the table, do nothing.
   */

    public void delete(String var) {
        if (!contains(var)) return;
        head = deleteUtil(var, head);
        size--;
    }

    private Node deleteUtil(String var, Node p) {
        if (p.variable.equals(var)) return p.next;
        p.next = deleteUtil(var, p.next);
        return p;
    }

  /*
   * Return the smallest variable in the lexicographic ordering (this will be in the first node in
   * the list); if the table is empty, return null.
   */

    public String min() throws KeyNotFoundException{
        if (size == 0) throw new KeyNotFoundException();
        return head.variable;
    }

  /*
   * Similar to the previous, but return the largest entry, which will be in the last node in the
   * linked list.
   */

    public String max() throws KeyNotFoundException{
        if (size == 0) throw new KeyNotFoundException();
        return lastKey(head);
    }

    private String lastKey(Node p) {
        if (p == null) return null; //Redundancy
        if (p.next == null) return p.variable;
        return lastKey(p.next);
    }

  /*
   * If the table is empty or if var is smaller than the smallest entry, return null; if var is in
   * the table, return var; otherwise, return the largest variable which is less than var (the entry
   * just before where var would be inserted into the table). If var is larger than the maximum key
   * in the table, return that maximum key. Do NOT insert var into the table if it is not there.
   * This is comparable to the mathematical function floor(...). [Hint: During the recursion, if
   * your current key equals var, then return it; else you should &quot;look ahead&quot; to see what
   * the next key is (checking first whether it is null!), and if the next key is larger than var,
   * or if there is no next key, your current key should be returned.]
   */

    public String floor(String var) throws KeyNotFoundException{
        if (size == 0 || var.compareTo(head.variable) < 0) throw new KeyNotFoundException();
        if (contains(var)) return var;
        if (var.compareTo(lastKey(head)) > 0) return lastKey(head);

        return floorUtil(var, head);
    }

    private String floorUtil(String var, Node p) {
        if (p.variable.compareTo(var) < 0 && p.next.variable.compareTo(var) > 0) return p.variable;
        return floorUtil(var, p.next);
    }

  /*
   * If the table is empty or if var is larger than the largest entry, return null; if var is in the
   * table, return var; otherwise, return the smallest variable which is larger than var (the entry
   * just after where var would be inserted into the table). (Do NOT insert var into the table!)
   * This is comparable to the mathematical function ceiling(...).
   */

    public String ceiling(String var) throws KeyNotFoundException{
        if (size == 0 || var.compareTo(lastKey(head)) > 0) throw new KeyNotFoundException();
        if (contains(var)) return var;
        if (var.compareTo(head.variable) < 0) return head.variable;
        return ceilingUtil(var, head);
    }

    private String ceilingUtil(String var, Node p) {
        if (p.variable.compareTo(var) < 0 && p.next.variable.compareTo(var) > 0) return p.next.variable;
        return ceilingUtil(var, p.next);
    }


  /*
   * Return the &quot;rank&quot; of var, i.e., the number of entries in the table which are smaller
   * than var; the rank of variables which are in the table is calculated by counting 0, 1, 2,
   * starting at the first node (as if it were an array); if var is not in the table, then it is the
   * rank where var would be if it were inserted (do NOT insert var into the table).
   */

    public int rank(String var) {
        if (head.variable.compareTo(var) > 0) return 0;
        if (lastKey(head).compareTo(var) < 0) return size;

        return rankUtil(var, 0, head);
    }

    private int rankUtil(String var, int n, Node p) {
        if (p.variable.equals(var)) return n;
        if (p.variable.compareTo(var) < 0 && p.next.variable.compareTo(var) > 0) return n + 1;
        return rankUtil(var, n + 1, p.next);
    }


  /*
   * Return the variable which is at rank n in the linked list (starting the count at 0 with the
   * first node, as in an array). If n is not the rank of any element, i.e., it is negative or is
   * equal to or larger than the length of the linked list, return null. You are essentially just
   * returning the variable at location n in the list, but starting the count with 0 at the first
   * node.
   */

    public String select(int n) throws KeyNotFoundException{
        if (n >= size || n < 0) throw new KeyNotFoundException();
        return selectUtil(n, 0, head);
    }

    private String selectUtil(int n, int k, Node p) {
        if (k == n) return p.variable;
        return selectUtil(n, k + 1, p.next);
    }



  /* Remove the smallest (i.e., first) entry in the table; if the table is empty, do nothing. */

    public void deleteMin() {
        if (size == 0) return;
        head = head.next;
        size--;
    }


  /*rank
   * Remove the largest (i.e., last) entry in the table; if the table is empty do nothing. Hint: you
   * can directly use a method from the Notes.....
   */

    public void deleteMax() {
        if (size == 0) return;
        if (size == 1) {
            head = null;
            size--;
            return;
        }
        size--;
        deleteMaxUtil(head);
    }

    private void deleteMaxUtil(Node p) {
        if (p.next.next == null) { //Find the second node from the tail
            p.next = null;
        } else {
            deleteMaxUtil(p.next);
        }

    }


  /*
   * Return the number of entries in the table (the length of the linked list); you should keep
   * track of this with a private variable <strong>size</strong>, which is updated when you remove
   * or add an entry.
   */

    public int size() {
        return size;
    }


  /*
   * Return the number of entries in the table whose variables are in the range [lo .. hi], that is,
   * that are >= lo and <= hi (using the appropriate String comparison operators). (Hint: use
   * the same &quot;example 2&quot; method as suggested in the case of mean(...) in problem B.2: go
   * down the list and keep a count of the number of variables which are in the range.)
   */

    public int size(String lo, String hi) {
        int l = rank(lo);
        int h = rank(hi);
        if(contains(hi))
            return h - l + 1;
        else
            return h - l;
    }

  /* Return true if the table has no entries, and false otherwise. */

    public boolean isEmpty() {
        return size == 0;
    }


    public String toString() {
        return toStringUtil(head);
    }

    private String toStringUtil(Node p) {
        if (p == null) return "";
        if (p.next == null) return "(" + p.variable + "," + p.value + ")";

        return "(" + p.variable + "," + p.value + ") : " + toStringUtil(p.next);
    }





    // You will need to have this in your class to satisfy the Iterable interface:

    public Iterator<String> iterator() {
        return new It();
    }

    // The iterator inner class It has access to private date in this ADT, including pointers into
    // the list of nodes.
    //TODO Implement "It" 's methods

    private class It implements Iterator<String> {

        private Node cursor;                   // where in the enumeration we are

        // constructor, sets cursor so enumeration starts at beginning of list

        public It() {
            cursor = head;
        }
        // interface methods required by Iterator interface

        public boolean hasNext() {
            return cursor != null;
        }

        public String next() {
            if (hasNext()) { //Is this if statement necessary?
                String s = cursor.variable;
                cursor = cursor.next;
                return s;
            }
            return null;  //Should throw exception?
        }

        public void remove() {             // required by interface but we won't implement it

        }
    }

    // similar to previous, but for a specific range -- not required by Iterable interface, but we'll use it


    public Iterator<String> iterator(String lo, String hi) {
        return new ItRange(lo,hi);
    }

    //TODO Implement "ItRange" 's method

    private class ItRange implements Iterator<String> {

        private Node cursor;
        private String hi;

        public ItRange(String lo, String hi) {
            this.hi = hi;
            try{
                cursor = findPosition(ceiling(lo), head);
            } catch(KeyNotFoundException e) {
                e.printStackTrace();
            }
        }

        // interface methods required by Iterator interface

        public boolean hasNext() {
            return cursor.variable.compareTo(hi) <= 0;
        }

        public String next() {
            if (hasNext()) {
                String tmp = cursor.variable;
                cursor = cursor.next;
                return tmp;
            }
            return null;
        }

        public void remove() {             // required by interface but we won't implement it

        }

    }



    public static void main(String[] args) {
        SymbolTable<Integer> S = new SymbolTable<Integer>();

 /*  Use step-wise refinement to develop the methods one at a time as you get to them
  *  in the following performance tests, and then move the "/*" down, to uncover more
  *  and more tests.
  *  Note: You will need to write the toString() method FIRST in order to run these
  *        performance tests.
  */

        // Insert three (key,value) pairs and test basic methods


        S.put("a",3);
        S.put("c",1);
        S.put("b",1);

        System.out.println("\n[1] Should print out:\n(a,3) : (b,1) : (c,1) ");
        System.out.println(S);

    //   move this line down past each test as you complete it, that way you don't have to look at a bunch of failed tests each time

    System.out.println("\n[2] Should print out:\n3");
    System.out.println(S.size());

    System.out.println("\n[3] Should print out:\nfalse");
    System.out.println(S.isEmpty());



    System.out.println("\n[4] Should print out:\n1");
    String testKey = "c";
    try {
      System.out.println(S.get(testKey));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key " + testKey + " does not exist!");
    }


    System.out.println("\n[5] Should print out:\nKey d does not exist!");
    testKey = "d";
    try {
      System.out.println(S.get(testKey));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key " + testKey + " does not exist!");
    }

    System.out.println("\n[6] Should print out:\n(a,3) : (b,1) : (c,4) ");
    S.put("c",4);
    System.out.println(S);

    System.out.println("\n[7] Should print out:\ntrue");
    System.out.println(S.contains("c"));

    System.out.println("\n[8] Should print out:\ntrue");
    System.out.println(S.contains("a"));

    System.out.println("\n[9] Should print out:\nfalse");
    System.out.println(S.contains("e"));


    S.delete("a");
    S.delete("d");
    S.delete("c");
    System.out.println("\n[10] Should print out:\n(b,1)");
    System.out.println(S);

    System.out.println("\n[11] Should print out:\n0");
    S.delete("b");
    System.out.println(S.size());

    System.out.println("\n[12] Should print out:\nnope! nope! nope! nope! nope!");
    try{
      System.out.println(S.min());
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! ");
    }

    try{
      System.out.println(S.max());
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! ");
    }


    try{
      System.out.println(S.floor("a"));
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! ");
    }

    try{
      System.out.println(S.ceiling("a"));
    }
    catch(KeyNotFoundException e) {
      System.out.print("nope! ");
    }


    try{
      System.out.println(S.select(0));
    }
    catch(KeyNotFoundException e) {
      System.out.println("nope! ");
    }



    SymbolTable<String> T = new SymbolTable<String>();

    T.put("09:00:00","Chicago");
    T.put("09:00:03","Phoenix");
    T.put("09:00:13","Houston");
    T.put("09:00:59","Chicago");
    T.put("09:36:14","Seattle");
    T.put("09:37:44","Phoenix");
    T.put("09:10:25","Seattle");
    T.put("09:14:25","Phoenix");
    T.put("09:19:32","Chicago");
    T.put("09:19:46","Chicago");
    T.put("09:21:05","Chicago");
    T.put("09:22:43","Seattle");
    T.put("09:01:10","Houston");
    T.put("09:03:13","Chicago");
    T.put("09:10:11","Seattle");
    T.put("09:25:52","Chicago");
    T.put("09:22:54","Seattle");
    T.put("09:35:21","Chicago");

    System.out.println("\n[13] Should print out:\n(09:00:00,Chicago) : (09:00:03,Phoenix) : (09:00:13,Houston) : (09:00:59,Chicago) : (09:01:10,Houston) : (09:03:13,Chicago) : (09:10:11,Seattle) : (09:10:25,Seattle) : (09:14:25,Phoenix) : (09:19:32,Chicago) : (09:19:46,Chicago) : (09:21:05,Chicago) : (09:22:43,Seattle) : (09:22:54,Seattle) : (09:25:52,Chicago) : (09:35:21,Chicago) : (09:36:14,Seattle) : (09:37:44,Phoenix)");
    System.out.println("\n" + T);

    try{
      System.out.println("\n[14] Should print out:\n09:00:00");
      System.out.println(T.min());
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:00:00 does not exist!");
    }
    try{
      System.out.println("\n[15] Should print out:\n09:37:44");
      System.out.println(T.max());
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:37:44 does not exist!");
    }

    try{
      System.out.println("\n[16] Should print out:\n09:03:13");
      System.out.println(T.floor("09:05:00"));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:05:00 does not exist!");
    }

    try{
      System.out.println("\n[17] Should print out:\n09:35:21");
      System.out.println(T.floor("09:35:21"));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:35:21 does not exist!");
    }

    try{
      System.out.println("\n[18] Should print out:\n09:35:21");
      System.out.println(T.ceiling("09:30:00"));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:35:21 does not exist!");
    }

    try{
      System.out.println("\n[19] Should print out:\n09:00:00");
      System.out.println(T.ceiling("09:00:00"));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:00:00 does not exist!");
    }

    try{
      System.out.println("\n[20] Should print out:\n09:10:25");
      System.out.println(T.select(7));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Key 09:10:25 does not exist!");
    }


    System.out.println("\n[21] Should print out:\n7");
    System.out.println(T.rank("09:10:25"));

    System.out.println("\n[22] Should print out:\n15");
    System.out.println(T.rank("09:30:00"));

    System.out.println("\n[23] Should print out:\n5");
    System.out.println(T.size("09:15:00", "09:25:00"));

    try {
      System.out.println("\n[24] Should print out:\n18 18");
      System.out.println(T.size() + " " + T.size(T.min(), T.max()));
    }
    catch(KeyNotFoundException e) {
      System.out.println("Symbol table empty!");
    }

    try {
      System.out.println("\n[25] Should print out:\n09:00:03");
      T.deleteMin();
      System.out.println(T.min());
    }
    catch(KeyNotFoundException e) {
      System.out.println("Symbol table empty!");
    }

    try {
      System.out.println("\n[26] Should print out:\n09:36:14");
      T.deleteMax();
      System.out.println(T.max());
    }
    catch(KeyNotFoundException e) {
      System.out.println("Symbol table empty!");
    }


    System.out.println("\n[27] Should print out:\n16");
    System.out.println(T.size());




    }
}


class KeyNotFoundException extends Exception {}

