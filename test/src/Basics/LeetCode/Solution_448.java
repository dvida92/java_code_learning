package Basics.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidzhou on 3/20/17.
 * 448.Find All Number Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description
 */
public class Solution_448 {



    /**
     * Use an extra array to tally the occurrence
     * @param nums
     * @return
     */
    public List<Integer> findDisapprearedNumbers1(int[] nums) {

        int length = nums.length;
        int[] tally = new int[length];
        for(int i = 0; i < length; i++) {
            tally[nums[i] - 1]++;
        }

        List<Integer> ret = new LinkedList<>();
        for(int i = 0; i < length; i++) {
            if(tally[i] == 0) {
                ret.add(i + 1);
            }
        }

        return ret;
    }


    /**
     * Using hashset to iterate twice
     * @param nums
     * @return
     */
    public List<Integer> findDisapprearedNumbers2(int[] nums) {

        List<Integer> ret = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                ret.add(i);
            }
        }

        return ret;
    }




}
