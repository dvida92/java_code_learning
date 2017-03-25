package Basics.LeetCode;

/**
 * Created by davidzhou on 3/21/17.
 * 83 Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
 */
public class Solution_83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }


    /**
     * 总结：处理linked list的时候，需要正确设置指针，在算法中进行恰当的操作，还需要考虑corner cases.
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode toDel = current.next;
        while (current.next != null) {
            if (current.val != toDel.val) {
                current = current.next;
                toDel = current.next;
            } else{
                current.next = toDel.next;
                toDel = current.next;
            }
        }
        return head;
    }
}
