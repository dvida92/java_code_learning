package Basics.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by davidzhou on 4/22/17.
 * 160. Intersection of Two Linked Lists
 */
public class Solution_160 {

    public class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }


    /**
     * Efficient Alg
     */

    public ListNode getIntersectionNode1(ListNode headA, ListNode headb) {

        return null;
    }

    /**
     * BF Algorithm
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        Set<ListNode> set = new HashSet<>();
        while (currentA != null || currentB != null) {

            if (currentA != null) {
                if (set.contains(currentA)) {
                    return currentA;
                } else {
                    set.add(currentA);
                    currentA = currentA.next;
                }
            }

            if (currentB != null) {
                if (set.contains(currentB)) {
                    return currentB;
                } else {
                    set.add(currentB);
                    currentB = currentB.next;
                }
            }

        }

        return null;

    }
}
