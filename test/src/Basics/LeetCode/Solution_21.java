package Basics.LeetCode;

/**
 * Created by davidzhou on 4/12/17.
 * 21.Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/#/description
 */
public class Solution_21 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode ret;
        ListNode pointer1;
        ListNode pointer2;
        ListNode retPointer;
        if (l1.val < l2.val) {
            ret = l1;
            retPointer = ret;
            pointer1 = l1.next;
            pointer2 = l2;
        } else {
            ret = l2;
            retPointer = ret;
            pointer1 = l1;
            pointer2 = l2.next;
        }

        while (pointer1 !=null && pointer2 != null) {
            if (pointer1.val > pointer2.val) {
                retPointer.next = pointer2;
                pointer2 = pointer2.next;
                retPointer = retPointer.next;
            } else {
                retPointer.next = pointer1;
                pointer1 = pointer1.next;
                retPointer = retPointer.next;
            }
        }

        if (pointer1 != null) {
            retPointer.next = pointer1;
        }

        if (pointer2 != null) {
            retPointer.next = pointer2;
        }

        return ret;
    }
}

