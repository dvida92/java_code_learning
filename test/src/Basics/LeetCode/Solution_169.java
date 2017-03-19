package Basics.LeetCode;

import java.util.Arrays;

/**
 * 169.Majority Element
 * https://leetcode.com/problems/majority-element/#/description
 */
public class Solution_169 {
    /**
     *
     * @param nums: nonempty array
     * @return The majority element
     */
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[0];
        }

        int a = majorityElement(Arrays.copyOfRange(nums,0, nums.length / 2));
        int b = majorityElement(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        if (a == b){
            if (counting(nums, a) > nums.length / 2) return a;
        }
        if (counting(nums, a) > counting(nums, b) && counting(nums, a) > nums.length / 2) return a;
        else if (counting(nums, b) > counting(nums, a) && counting(nums, b) > nums.length / 2) return b;
        else if (counting(nums, a) == counting(nums, b)) return a;
        throw new IllegalArgumentException("Not Reachable!");
    }

    public static int counting(int[]nums, int key) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) counter++;
        }
        return counter;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
