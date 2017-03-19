package Basics.LeetCode;

import java.util.HashSet;

/**
 * Created by davidzhou on 3/19/17.
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/#/description
 */
public class Solution_217 {

    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (mySet.contains(nums[i])) {
                return true;
            } else {
                mySet.add(nums[i]);
            }
        }
        return false;
    }
}
