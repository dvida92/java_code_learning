package Basics.LeetCode;

import java.util.HashSet;

/**
 * Created by davidzhou on 4/11/17.
 * 3.Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 */
public class Solution_3 {

    /**
     * More efficient implementation using hash map, runs in O(n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {

        return 0;
    }
        /**
         * Time Limit Exceed - not efficient enough
         * BF Running Time: O(n^2)
         * @param s
         * @return
         */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;

        int longestSubstringSoFar = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j = i; j < charArray.length; j++) {
                if (!hashSet.contains(charArray[j])) {
                    hashSet.add(charArray[j]);
                } else {
                    break;
                }
            }
            if (hashSet.size() > longestSubstringSoFar) longestSubstringSoFar = hashSet.size();
        }

        return longestSubstringSoFar;
    }

}
