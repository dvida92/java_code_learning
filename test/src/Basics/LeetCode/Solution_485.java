package Basics.LeetCode;

/**
 * 485 Max Consecutive ones
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * int [] nums = {1, 0, 0, 1, 1, 0, 1, 1, 1}
 */


public class Solution_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 1) {
            if (nums[0] == 0) return 0;
            if (nums[0] == 1) return 1;
        }

        int value = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            value = 0;
            if (nums[i] == 1) {
                value = 1;

                int k = 1;
                while (true) {
                    if(i + k < nums.length && nums[i+k] == 1) {
                        value++;
                        k++;
                    }
                    else break;
                }

            }
            if(value > max) max = value;
        }


        return max;
    }

}
