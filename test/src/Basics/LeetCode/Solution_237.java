package Basics.LeetCode;

/**
 * 需要加强对linkedList的理解
 * 237.Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/#/description
 */
public class Solution_237 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
