package Basics.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by davidzhou on 4/15/17.
 * 53.Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/#/description
 */
public class Solution_53 {

    /**
     * BF Algorithm: time limit exceed
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                pq.add(sum);
            }
        }
        return pq.peek();
    }

    /**
     * TODO: DP solution
     * More efficient implementation
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,2,3};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));
    }
}
