package Basics.LeetCode;

/**
 *  Island Parameter
 *  https://leetcode.com/problems/island-perimeter/
 */
public class Solution_463 {

    public int islandPerimeter(int[][] grid) {

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    sum += 4;
                    if(i-1>=0 && grid[i-1][j] == 1) sum--;
                    if(i+1 <= grid.length - 1 && grid[i+1][j] == 1) sum--;
                    if(j+1 <= grid[0].length - 1 && grid[i][j+1] == 1) sum--;
                    if(j-1 >= 0 && grid[i][j-1] == 1) sum--;
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}; //注意二维数组的赋值和数组下标关系
        Solution_463 s = new Solution_463();
        System.out.println(s.islandPerimeter(grid));

        for (int i = 0; i < 4; i++) {
            System.out.println(grid[0][i]);
        }
    }
}

/*

3 xxxxxxx
2 x11111x
1 x11111x
0 xxxxxxx
  0123456


 */