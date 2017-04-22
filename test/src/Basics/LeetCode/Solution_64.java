package Basics.LeetCode;

/**
 * Created by davidzhou on 4/17/17.
 * 64.Minimum Path Sum
 */
public class Solution_64 {

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return DP(grid.length - 1, grid[0].length - 1, grid, memo);
    }

    public int DP(int i, int j, int[][] grid, int[][] memo) {
        //Base Case
        if (i == 0 && j == 0) return grid[0][0];

        //Memoization
        if (memo[i][j] != 0) return memo[i][j];

        if (i == 0) {
            int answer = DP(i, j - 1, grid, memo) + grid[i][j];
            memo[i][j] = answer;
            return answer;
        }

        if (j == 0) {
            int answer = DP(i - 1, j, grid, memo) + grid[i][j];
            memo[i][j] = answer;
            return answer;
        }

        int answer = Math.min(DP(i, j - 1, grid, memo), DP(i - 1, j, grid, memo)) + grid[i][j];
        memo[i][j] = answer;
        return answer;
    }

}
