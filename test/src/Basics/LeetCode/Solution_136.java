package Basics.LeetCode;

/**
 * 136 Single Number: In an array every element appear twice except one
 * Find that element. You algorithm should run in linear time. Try not to use extra memory!
 */
public class Solution_136 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];

        }
        return result;
    }

    public static void main(String[] args) {
        int nums [] = {1,1,2,2,3};
        Solution_136 sss = new Solution_136();
        System.out.println(sss.singleNumber(nums));
    }
}
