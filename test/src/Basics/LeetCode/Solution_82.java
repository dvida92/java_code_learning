package Basics.LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by davidzhou on 6/8/17.
 */
public class Solution_82 {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }

            cur = cur.next;
        }
        return dummyHead.next;
    }

}
