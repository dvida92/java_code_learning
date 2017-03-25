package Basics.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidzhou on 3/20/17.
 * 448.Find All Number Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description
 */
public class Solution_448 {

    /**
     * 超时
     * @param nums
     * @return
     */
    public static List<Integer> findDisapprearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ret.add(i + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (ret.get(nums[i] - 1) > 0) ret.set(nums[i] - 1, 0);
        }

        while (ret.contains((Integer)0)) ret.remove((Integer) 0);

        return ret;
    }




}
