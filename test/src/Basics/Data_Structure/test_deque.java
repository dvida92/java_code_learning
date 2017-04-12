package Basics.Data_Structure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Can be used both as a queue and a stack.
 * Can add and remove element at both sides
 * Created by davidzhou on 4/12/17.
 * https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
 */
public class test_deque {
    public static void main(String[] args) {
        Deque<String> q = new LinkedList<>();

        //Demonstrate FIFO
        q.addFirst("a");
        q.addFirst("b");
        q.addFirst("c");
        System.out.println(q);
        q.removeLast();
        System.out.println(q);


        Deque<String> q2 = new LinkedList<>();

        //Demonstrate FILO
        q2.push("a");
        q2.push("b");
        q2.push("c");
        System.out.println("A stack: " + q2);
        q2.pop();
        System.out.println(q2);
    }

}
