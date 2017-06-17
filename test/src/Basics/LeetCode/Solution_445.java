package Basics.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by davidzhou on 4/23/17.
 * 445. Add Two Numbers II
 *
 */
public class Solution_445 {

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Use two stacks to collect node's values
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode result = new ListNode(0);
        while (stack1.size() != 0 || stack2.size() != 0) {
            sum = sum / 10;
            if (stack1.size() != 0) {
                sum += stack1.pop();
            }
            if (stack2.size() != 0) {
                sum += stack2.pop();
            }
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = result;
            result = tmp;
        }
        if (sum / 10 == 1){
            ListNode tmp = new ListNode(1);
            tmp.next = result;
            result = tmp;
        }


        //Delete the last node "dummy node"
        ListNode r1 = result;
        ListNode r2 = result.next;
        while (r2.next != null) {
            r1 = r1.next;
            r2 = r1.next;
        }
        r1.next = null;
        return result;

    }

    /**
     * Reverse Linked list first, then perform addition
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversel1 = reverseList(l1);
        ListNode reversel2 = reverseList(l2);

        int sum = 0;
        ListNode p1 = reversel1;
        ListNode p2 = reversel2;
        ListNode result = new ListNode(0); //Dummy Node '0'
        ListNode resultHead = result;
        while (p1 != null || p2 != null) {

            sum = sum / 10;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            result.next = new ListNode(sum % 10);
            result = result.next;
        }
        if (sum / 10 == 1) result.next = new ListNode(1);
        return reverseList(resultHead.next);

    }

    private ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }

        head.next = null;
        return p1;
    }
}
