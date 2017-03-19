package Basics.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 349 Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/#/description
 */
public class Solution_349 {

    /**
     *  USING TWO hashSets: a set is a well-defined collection of distinct objects.
     * @param nums1
     * @param nums2
     * @return The intersection of the two arrays; The elements in this array must be
     * unique.
     * Example:
     *  nums1 = {1,2,3,4,4}
     *  nums2 = {3,2,2}
     *  return: {2,3}
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        int[] arrayResult = new int[result.size()];
        int counter = 0;
        for (Integer num:
             result) {
            arrayResult[counter++] = num;
        }

        return arrayResult;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,4};
        int[] nums2 = {3,2,2,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
