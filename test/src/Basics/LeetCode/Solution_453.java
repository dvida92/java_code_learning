package Basics.LeetCode;



/**
 * Minimum Moves to Equal Array Elements
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/#/description
 * Summary: 等价变换思维;这道题重点还是数学思想，编程仅仅是执行部分。
 */
public class Solution_453 {

    /**
     * Running time: O(n)
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        int min = nums[0];
        int totalMove = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            totalMove += nums[i] - min;
        }
        return totalMove;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println(minMoves(nums));
    }
}
