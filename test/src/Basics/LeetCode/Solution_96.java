package Basics.LeetCode;

/**
 * Created by davidzhou on 4/20/17.
 * 96. Unique Binary Search Tree: how many combinations?
 * https://leetcode.com/problems/unique-binary-search-trees/#/description
 */
public class Solution_96 {


    /**
     * Without memoization: Time Limit Exceed
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[][] memo = new int[n][n];
        return numTreesUtil(1, n, memo);
    }

    /**
     * Helper function
     * @param low
     * @param high
     * @return the possible number of BST combinations using number from
     * low to high
     */
    private static int numTreesUtil(int low, int high, int[][] memo) {
        if (low >= high) return 1;
        if (memo[low - 1][high - 1] != 0) return memo[low - 1][high - 1];
        int sum = 0;
        for (int i = low; i <= high ; i++) {
            sum += numTreesUtil(low, i - 1, memo) *
                    numTreesUtil(i + 1, high, memo);
        }
        memo[low - 1][high - 1] = sum;
        return sum;
    }



    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }



}
