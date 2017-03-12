package Basics.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  283 Move Zeroes
 *  https://leetcode.com/problems/move-zeroes/?tab=Description
 *  Comment: Feels like quickSort
 */
public class Solution_283 {

    /**
     * Requirement:
     * 1) In-place so no extra memory to copy the array.
     * 2) Minimize the total number of operations.
     * @param nums an array with some zeroes elements
     * @return the sorted array "nums" that has all zeroes at the end of the
     * sequence
     * For example: given nums = [0,1,0,3,12], output num = [1,3,12,0,0]
     */
    public static int[] moveZero(int[] nums) {
        int j = 0; // This pointer is similar to quick sort?
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums = {1,0,7,3,5,4,0,0,6};
        moveZero(nums);
    }
}
