package Basics.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by davidzhou on 4/14/17.
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/#/description
 */
public class Solution_141 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }


    /**
     * Given a linked list, determine if it has a cycle in it.
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != slowPointer) {
            if (fastPointer.next == null) return false;
            fastPointer = fastPointer.next;
            if (fastPointer.next == null) return false;
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return true;
    }


    /**
     * Using extra space
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;
        ListNode iter = head;
        HashSet<ListNode> copyOfPointer = new HashSet<>();
        while (iter != null) {
            if (!copyOfPointer.add(iter)) return true;
            iter = iter.next;
        }
        return false;
    }
}
