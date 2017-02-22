package Basics.LeetCode;

/**
 * 389 Find the difference
 * https://leetcode.com/problems/find-the-difference/
 * WRONG!!
 */
public class Solution_389 {
    public static char findTheDifference(String s, String t) {
        char [] c1 = s.toCharArray();
        char [] c2 = t.toCharArray();

        for(int i = 0; i < t.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                if(c2[i] == c1[j]) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) return c2[i];
        }
        throw new IllegalArgumentException("String's wrong!");
    }

    public static void main(String[] args) {
        char c = Solution_389.findTheDifference("abc", "abc");
        System.out.println(c);
    }
}
