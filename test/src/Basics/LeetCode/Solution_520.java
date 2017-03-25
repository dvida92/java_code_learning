package Basics.LeetCode;

/**
 * Created by davidzhou on 3/20/17.
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/#/description
 */
public class Solution_520 {

    /**
     * Using ASCII Value "91"
     * @param word Non-empty word consisting of uppercase and lowercase latin letters
     * @return If the word use capital letters correctly
     * 没有考虑全test cases: when wordChar.length = 1
     */
    public static boolean isValid(String word) {
        char[] wordChar = word.toCharArray();
        if (wordChar.length == 1) return true;
        if (wordChar[0] < 91) {
            if (wordChar[1] < 91) { //USA
                for (int i = 2; i < wordChar.length; i++) {
                    if (wordChar[i] > 91) return false;
                }
            } else { //America
                for (int i = 2; i < wordChar.length; i++) {
                    if (wordChar[i] < 91) return false;
                }
            }
        } else{ //apple
            for (int i = 1; i < wordChar.length; i++) {
                if (wordChar[i] < 91) return false;
            }
        }
        return true;
    }
}
