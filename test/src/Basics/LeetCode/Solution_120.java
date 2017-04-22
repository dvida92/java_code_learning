package Basics.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidzhou on 4/17/17.
 * 120.Triangle
 * https://leetcode.com/problems/triangle/#/description
 */
public class Solution_120 {

    /**
     * DP Top-down Solution using extra O(n^2) space with memoization
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.size()];
        return DP(triangle, 0, 0, memo);
    }

    private int DP(List<List<Integer>> triangle, int j, int i, int[][] memo) {
        if (memo[j][i] != 0) return memo[j][i];
        if (j == triangle.size() - 1) {
            memo[j][i] = triangle.get(j).get(i);
            return memo[j][i];
        }

        memo[j][i] = triangle.get(j).get(i) + Math.min(DP(triangle, j + 1, i, memo),
                DP(triangle, j + 1, i + 1, memo));
        return memo[j][i];
    }


    /**
     * TODO:DP Bottom-up Approach
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {

        return 0;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();

        LinkedList<Integer> l1 = new LinkedList();
        l1.add(2);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(4);

        LinkedList<Integer> l3 = new LinkedList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);

        LinkedList<Integer> l4 = new LinkedList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        System.out.println(list);
        Solution_120 t1 = new Solution_120();
        System.out.println(t1.minimumTotal(list));

    }
}
