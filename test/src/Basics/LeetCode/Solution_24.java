package Basics.LeetCode;

/**
 * Created by davidzhou on 6/8/17.
 * Redo
 */
public class Solution_24 {
    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode p = head;
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;

        while (p != null && p.next != null) {
            pre.next = p.next;
            ListNode tmp = p.next.next;
            p.next.next = p;
            p.next = tmp;
            p = tmp;
            pre = pre.next.next;
        }
        return dummyHead.next;
    }
}
