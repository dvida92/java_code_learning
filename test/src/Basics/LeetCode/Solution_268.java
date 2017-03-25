package Basics.LeetCode;

import java.util.HashSet;

/**
 * Created by davidzhou on 3/20/17.
 * 268 Missing number
 * https://leetcode.com/problems/missing-number/#/description
 */
public class Solution_268 {

    /**
     * Linear time and linear extra Space
     * @param nums
     * @return
     */
    public static int missing(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length + 1; i++) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) set.remove((Integer) nums[i]);
        }

        int ret = 0;
        for (Integer n :
                set) {
            ret = n;
        }
        return ret;
    }

    /**
     * Linear time using constant extra space
     * @param nums an array with distinct elements; not sorted
     * @return
     */
    public static int missing2(int[] nums) {
        return 0;
    }

}
