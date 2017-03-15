package Basics.LeetCode;

import java.util.Arrays;

/**
 *  Assign Cookies: see the description in the LINK
 *  https://leetcode.com/problems/assign-cookies/#/description
 */
public class Solution_455 {

    /**
     *
     * @param g  children's minimum satisfying cookie sizes
     * @param s  cookie sizes
     * @return
     */
    public static int findContentChildren(int[] g, int [] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int pointerG = 0;
        int pointerS = 0;
        int totalContentChildren = 0;
        while (pointerG < g.length && pointerS < s.length) {
            if (g[pointerG] <= s[pointerS]) {
                totalContentChildren++;
                pointerG++;
                pointerS++;
            } else if (g[pointerG] > s[pointerS]) {
                pointerS++;
            }
        }

        return totalContentChildren;
    }

    public static void main(String[] args) {
        int[]g = {1,2};
        int[]s = {1,2,3};
        System.out.println(findContentChildren(g,s));
    }
}
