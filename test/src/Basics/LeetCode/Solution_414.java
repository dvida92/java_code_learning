package Basics.LeetCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by davidzhou on 4/14/17.
 * 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/#/description
 */
public class Solution_414 {


    /**
     * TODO: Doesn't work when nums contains MIN_VALUE
     * Running Time: O(n)
     * @param nums
     * @return the third maximum
     */
    public static int thirdMax(int[] nums) {


        int firstMAX = Integer.MIN_VALUE;
        int secondMAX = Integer.MIN_VALUE;
        int thirdMAX = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMAX) {
                thirdMAX = secondMAX;
                secondMAX = firstMAX;
                firstMAX = nums[i];
            } else if (nums[i] > secondMAX && nums[i] < firstMAX) {
                thirdMAX = secondMAX;
                secondMAX = nums[i];
            } else if (nums[i] >= thirdMAX && nums[i] < secondMAX) {
                thirdMAX = nums[i];
            }
        }

        if (thirdMAX == Integer.MIN_VALUE ) return firstMAX;
        return thirdMAX;
    }


    /**
     * Use Priority Queue
     * @param nums
     * @return
     */
    public static int thirdMax1(int[] nums) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                pQueue.add(nums[i]);
            }
        }

        if (pQueue.size() < 3) return pQueue.poll();
        pQueue.poll();
        pQueue.poll();
        return pQueue.poll();
    }


}
