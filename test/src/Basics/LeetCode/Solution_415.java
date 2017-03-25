package Basics.LeetCode;

/**
 * 错题
 * Created by davidzhou on 3/21/17.
 * 415 Add String
 * https://leetcode.com/problems/add-strings/#/description
 */
public class Solution_415 {

    public static String addStrings(String num1, String num2) {
        char[] cnum1 = num1.toCharArray();
        char[] cnum2 = num2.toCharArray();

        int value1 = 0;
        for (int i = 0; i < cnum1.length; i++) {
            value1 += (cnum1[i] - 48) * Math.pow(10, cnum1.length - 1 - i);
        }

        int value2 = 0;
        for (int i = 0; i < cnum2.length; i++) {
            value2 += (cnum2[i] - 48) * Math.pow(10, cnum2.length - 1 - i);
        }

        int result = value1 + value2;
        return result + "";
    }

    public static void main(String[] args) {
        String num1 = "500";
        String num2 = "10";
        System.out.println(addStrings(num1, num2));
    }
}
