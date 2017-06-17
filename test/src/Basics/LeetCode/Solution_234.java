package Basics.LeetCode;

import java.util.ArrayList;

/**
 * Created by davidzhou on 4/23/17.
 * 234. Palindrome Linked List
 *
 */


public class Solution_234 {


    /**
     * Efficient Implementation running in O(n) time and O(1) space
     * Reverse first half and check if symmetric
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        return false;

    }

    /**
     * Naive Approach
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>();
        ListNode iter = head;
        if (head == null) return true; //?
        if (head.next == null) return true;

        while (iter != null) {
            array.add(iter.val);
            iter = iter.next;
        }

        int low = 0;
        int high = array.size() - 1;
        while (low <= high) {
            //TODO: 对象之间要用equals方法比较,用"="是在比较内存地址的值
            if (! array.get(low).equals(array.get(high)) ) { return false; }
            low++;
            high--;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(isPalindrome(head));
    }
}
