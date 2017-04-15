package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 4/15/17.
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/#/description
 */
public class Solution_27 {


    /**
     * 体会思想
     * @param nums
     * @param val
     * @return
     */
    public static int removeDuplicates(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter++] = nums[i];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,2,6};
        System.out.println(removeDuplicates(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

}
