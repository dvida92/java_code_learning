package Basics.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidzhou on 4/14/17.
 * 442.Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description
 */
public class Solution_442 {


    /**
     * Using a hash table
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) ret.add(nums[i]);
        }

        return ret;
    }

}
