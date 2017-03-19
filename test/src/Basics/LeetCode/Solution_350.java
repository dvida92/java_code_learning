package Basics.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 错题！！！
 * Created by davidzhou on 3/19/17.
 * 350.Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/#/description
 */
public class Solution_350 {

    /**
     * 算法错误
     * @param nums1
     * @param nums2
     * @return
     * Example: nums1 = [1,2,2,1], nums2 = [2,2], ret = [2,2]
     *
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        LinkedList<Integer> ret = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] == nums2[pointer2]) {
                ret.add(nums1[pointer1]);
                pointer2++;
            }
            pointer1++;

        }

        int[] retArray = new int[ret.size()];
        int i = 0;
        for (Integer n :
                ret) {
            retArray[i++] = n;
        }

        return retArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2,2};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
