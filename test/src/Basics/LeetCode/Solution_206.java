package Basics.LeetCode;

/**
 * Created by davidzhou on 3/19/17.
 * 206.Reverse Linked list
 * https://leetcode.com/problems/reverse-linked-list/#/description
 */
public class Solution_206 {


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


        //TODO: Shift + tab 选中代码整体向左平移

    /**
     * Iterative Algorithm
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode newHead = new ListNode(head.val);
            newHead.next = null;
            for (ListNode n = head.next; n != null; n = n.next) {
                ListNode newNode = new ListNode(n.val);
                newNode.next = newHead;
                newHead = newNode;
            }

            return newHead;
        }

    /**
     * Recursive Algorithm
     * @param head
     * @return
     */
    public ListNode reverseListRecur(ListNode head) {
        return null;

    }



}
