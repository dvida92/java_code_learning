package Basics.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidzhou on 4/20/17.
 * 1.Two Sum
 * https://leetcode.com/problems/two-sum/#/description
 */
public class Solution_1 {

    /**
     * Brute Force Algorithm
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] ret = new int[2];
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        throw new IllegalArgumentException("Not Reachable!");
    }

    /**
     * More efficient Alg:体会算法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("");
    }


    public static void main(String[] args) {
        int[] nums = {3, 3, 1, 6, 9};
        System.out.println(Arrays.toString(twoSum2(nums, 6)));
    }
}
