package Basics.LeetCode;

import java.util.Arrays;

/**
 *  506 Relative Rank
 *  https://leetcode.com/problems/relative-ranks/?tab=Description
 */
public class Solution_506 {

    public static String[] relativeRank(int[] nums) {
        
        int [] originalNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            originalNums[i] = nums[i];            
        }
        
        Arrays.sort(nums); //Quicksort: O(nlogn)

        String [] rank = new String[nums.length];
        for (int i = 0; i < originalNums.length; i++) {
            //Use binary search to find the element's ranking in the sorted array O(logn)
            rank[i] = Integer.toString(nums.length - Arrays.binarySearch(nums, originalNums[i]));
            //CAUTION: To compare string value, use method .equals("xxx")
            if (rank[i].equals("1")) rank[i] = "Gold Medal";
            if (rank[i].equals("2"))  rank[i] = "Silver Medal";
            if (rank[i].equals("3"))  rank[i] = "Bronze Medal";
        }

        return rank;

    }

    public static void main(String[] args) {
        int [] nums = {7,2,4,1};
        System.out.println(Arrays.toString(relativeRank(nums)));
    }
}
