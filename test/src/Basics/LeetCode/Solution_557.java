package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 4/14/17.
 *
 * 557. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/#/solutions
 */
public class Solution_557 {

    public static String reverseWords(String s) {

        char[] word = s.toCharArray();
        int i = 0;
        for (int j = 0; j < word.length; j++) {
            if (word[j] == ' ') {
                reverse(word, i, j - 1);
                i = j + 1;

            }
        }
        reverse(word, i, word.length - 1);

        return new String(word);
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        String s = "let's take leetcode contest!";
        System.out.println(reverseWords(s));
    }

}
