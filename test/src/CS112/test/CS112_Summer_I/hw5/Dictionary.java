package CS112.test.CS112_Summer_I.hw5;

/**
 * Created by davidzhou on 6/17/17.
 */

/*
 * File: dictionarious.java
 * Author: Wayne Snyder
 * Date: June 15th, 2017
 * Purpose: interface for dictionary in hw05, CS 112, Summer I, 2017.
 */



public interface Dictionary<Value> {

    // NOTE: comments precede the method stub they specify

  /*
   * If the variable var is not in the symbol table, insert a new node containing var and val into
   * the linked list in ascending order (do NOT sort the list, but insert in order of the variable
   * field); if var is already in the table, then simply replace the existing value with the new
   * value val. The type Value is a generic type.
   */

    public void put(String var, Value val);

  /*
   * Return the value associated with the variable var, or return null if var is not in the table.
   */

    public Value get(String var) throws KeyNotFoundException;

  /*
   * Return true or false, depending on whether var is in the table or not.
   */

    public boolean contains(String var);

  /*
   * Remove the node containing var from the table; if var is not in the table, do nothing.
   */

    void delete(String var);

  /*
   * Return the smallest variable in the lexicographic ordering (this will be in the first node in
   * the list); if the table is empty, return null.
   */

    public String min() throws KeyNotFoundException;

  /*
   * Similar to the previous, but return the largest entry, which will be in the last node in the
   * linked list.
   */

    public String max() throws KeyNotFoundException;

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

    public String floor(String var) throws KeyNotFoundException;

  /*
   * If the table is empty or if var is larger than the largest entry, return null; if var is in the
   * table, return var; otherwise, return the smallest variable which is larger than var (the entry
   * just after where var would be inserted into the table). (Do NOT insert var into the table!)
   * This is comparable to the mathematical function ceiling(...).
   */

    public String ceiling(String var) throws KeyNotFoundException;


  /*
   * Return the &quot;rank&quot; of var, i.e., the number of entries in the table which are smaller
   * than var; the rank of variables which are in the table is calculated by counting 0, 1, 2,
   * starting at the first node (as if it were an array); if var is not in the table, then it is the
   * rank where var would be if it were inserted (do NOT insert var into the table).
   */

    public int rank(String var);


  /*
   * Return the variable which is at rank n in the linked list (starting the count at 0 with the
   * first node, as in an array). If n is not the rank of any element, i.e., it is negative or is
   * equal to or larger than the length of the linked list, return null. You are essentially just
   * returning the variable at location n in the list, but starting the count with 0 at the first
   * node.
   */

    public String select(int n) throws KeyNotFoundException;


  /* Remove the smallest (i.e., first) entry in the table; if the table is empty, do nothing. */

    public void deleteMin();


  /*
   * Remove the largest (i.e., last) entry in the table; if the table is empty do nothing. Hint: you
   * can directly use a method from the Notes.....
   */

    public void deleteMax();


  /*
   * Return the number of entries in the table (the length of the linked list); you should keep
   * track of this with a private variable <strong>size</strong>, which is updated when you remove
   * or add an entry.
   */

    public int size();


  /*
   * Return the number of entries in the table whose variables are in the range [lo .. hi], that is,
   * that are &gt;= lo and &lt;= hi (using the appropriate String comparison operators). (Hint: use
   * the same &quot;example 2&quot; method as suggested in the case of mean(...) in problem B.2: go
   * down the list and keep a count of the number of variables which are in the range.)
   */

    public int size(String lo, String hi);

  /* Return true if the table has no entries, and false otherwise. */

    public boolean isEmpty();

}