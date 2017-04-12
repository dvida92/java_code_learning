package Basics.LeetCode;

import java.util.Arrays;

/**
 * Ransome Note: Review the "better version"
 * https://leetcode.com/problems/ransom-note/#/description
 */
public class Solution_383 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        Arrays.sort(ran);
        Arrays.sort(mag);

        for (int i = 0; i < ran.length; i++) {
            int index = Arrays.binarySearch(mag, ran[i]);
            while (index - 1 >= 0 && mag[index] == mag[index - 1]) {
                index--;
            }
            if (index >= 0) {
                mag = Arrays.copyOfRange(mag, index + 1, mag.length);
            }
            if (index < 0) return false;
        }
        return true;


    }


    /**
     *  A better version: why this is better than mine?
            */

    public static boolean canConstruct2(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int[] letterCounter = new int[52];

        for (int i = 0; i < mag.length; i++) {
            int index = mag[i] - 'A';
            if (index < 26) letterCounter[index]++; //ASCII 'A'-'Z'（65 - 90）和'a'-'z'（97-122） 中间有其他6个字符
            else letterCounter[index - 6]++;
        }

        for (int i = 0; i < ran.length; i++) {
            int index2 = ran[i] - 'A';
            if (index2 < 26) {
                /**
                 * --i 和 i--
                 */
                if (--letterCounter[index2] < 0) return false;

            } else {
                if (--letterCounter[index2 - 6] < 0) return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String ransomNote = "acdef";
        String magazine = "cccasdfasdfe";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstruct2(ransomNote, magazine));
    }
}
