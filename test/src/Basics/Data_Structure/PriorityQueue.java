package Basics.Data_Structure;

import java.util.Collections;

/**
 * Created by davidzhou on 4/14/17.
 */
public class PriorityQueue {

    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>(Collections.reverseOrder());
        java.util.PriorityQueue<Integer> priorityQueue1 = new java.util.PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(1);

        priorityQueue1.add(2);
        priorityQueue1.add(3);
        priorityQueue1.add(1);

        System.out.println("Natural Order:");
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());
        System.out.println("Reversed Order:");
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}
