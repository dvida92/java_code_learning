package Basics.LeetCode;

/**
 * Created by davidzhou on 4/22/17.
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/#/description
 */

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution_2 {



    /**
     *  Time Limit Exceeds: Not efficient enough
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode(0); // remove the first node when done
        ListNode resultRet = result;
        int carry = 0;
        while (p1 != null && p2 != null) {
            if (p1.val + p2.val + carry >= 10) {
                result.next = new ListNode(carry + p1.val + p2.val - 10);
                carry = 1;
                p1 = p1.next;
                p2 = p2.next;
                result = result.next;
            } else {
                result.next = new ListNode(carry + p1.val + p2.val);
                carry = 0;
                p1 = p1.next;
                p2 = p2.next;
                result = result.next;
            }
        }

        while (p1 != null) {
            if (p1.val + carry >= 10) {
                result.next = new ListNode(p1.val + carry - 10);
                carry = 1;
                result = result.next;
                p1 = p1.next;
            } else {
                result.next = new ListNode(p1.val + carry);
                carry = 0;
                result = result.next;
                p1 = p1.next;
            }

        }

        while (p2 != null) {
            if (p2.val + carry >= 10) {
                result.next = new ListNode(p2.val + carry - 10);
                carry = 1;
                result = result.next;
                p2 = p2.next;
            } else {
                result.next = new ListNode(p2.val + carry);
                carry = 0;
                result = result.next;
                p2 = p2.next;
            }
        }

        if (carry == 1) {
            result.next = new ListNode(1);
        }


        return resultRet.next;
    }

    /**
     * Official Answer: better control flow
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pr = result;
        ListNode p1 = l1;
        ListNode p2 = l2;

        int sum = 0;
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
        if (sum / 10 == 1) {
            result.next = new ListNode(1);
        }
        return pr.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(2);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);

        ListNode result = addTwoNumbers(l1, l2);
        ListNode result1 = addTwoNumbers1(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }

    }
}
