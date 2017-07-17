package CS112.test.CS112_Summer_I.hw5;

/* File: GenericPQueue.java
 * Date: 6/14/17
 * Author:  Stephany Prodromos
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


   // Your code here!  Remember, if you have a declarations
   //      Item x;
   //      Item y;
   // then you can call x.compareTo(y)

   private int size = 0;
   private Node head = null;

   /**
    * Insert an item and maintain descending order
    * @param item
    */
   public void insert(Item item) {
      head = insertInOrder(item, head);
      size++;
   }

   /**
    * Helper function for insert()
    * @param item
    * @param p
    * @return
    */
   private Node insertInOrder(Item item, Node p) {
      if (p == null) return new Node(item, null);
      if (p.item.compareTo(item) < 0) return new Node(item, p);

      p.next = insertInOrder(item, p.next);
      return p;
   }


   public Item getMax() {
      Item tmp = head.item;
      head = head.next;
      size--;
      return tmp;
   }


   public int size() {
      return size;
   }


   public boolean isEmpty() {
      return size == 0;
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