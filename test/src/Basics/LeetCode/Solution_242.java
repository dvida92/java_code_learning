package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 3/19/17.
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/#/description
 */
public class Solution_242 {

    public boolean isAnagram(String s, String t) {
        char[] cS = s.toCharArray();
        char[] cT = t.toCharArray();
        Arrays.sort(cS);
        Arrays.sort(cT);
        if (cS.length != cT.length) return false;
        for (int i = 0; i < cS.length; i++) {
            if (cS[i] != cT[i]) return false;
        }
        return true;
    }
}
