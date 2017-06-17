package Basics.LeetCode;

/**
 * Created by davidzhou on 4/22/17.
 * 203 Remove Linked List elements
 */
public class Solution_203 {

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.next == null) {
            if (head.val == val) return null;
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        if (head.val == val) {
            head = head.next;
        }

        return head;
    }
}
