package Basics.LeetCode;

/**
 * Created by davidzhou on 4/23/17.
 * 19.Remove Nth Node From End of List
 */
public class Solution_19 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Take care of corner cases
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode iter = head;
        while (iter != null) {
            length++;
            iter = iter.next;
        }

        if (length == 0) return null;
        if (length == 1 && n == 1) return null;

        if (n == length) return head.next;

        int counter = length - n - 1;
        ListNode iter2 = head;
        while (counter > 0) {
            iter2 = iter2.next;
            counter--;
        }
        iter2.next = iter2.next.next;

        return head;
    }
}
