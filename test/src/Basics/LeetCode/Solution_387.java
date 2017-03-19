package Basics.LeetCode;

import java.util.Arrays;

/**
 * 387.First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/#/description
 */
public class Solution_387 {


    /**
     * My Alg: sort the string first and then iterate the original array, using binary
     * search on the sorted array.
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        char[] originalWord = s.toCharArray();
        char[] sortedWord = s.toCharArray();
        Arrays.sort(sortedWord);

        if (originalWord.length == 1){
            return 0;
        }

        for (int i = 0; i < originalWord.length; i++) {
            int index = Arrays.binarySearch(sortedWord, originalWord[i]);
            if (index == 0) {
                if (sortedWord[index + 1] != sortedWord[index]) return i;
            } else if (index > 0 && index < originalWord.length -1) {
                if (sortedWord[index + 1] != sortedWord[index] &&
                        sortedWord[index - 1] != sortedWord[index]) return i;
            } else if (index == originalWord.length - 1 &&
                    sortedWord[index - 1] != sortedWord[index]) return i;

        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "";
        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));

    }
}
