package Basics.LeetCode;

/**
 * Add Digits: Given a non-negative integer num, repeatedly add all its digits
 * until the result has only one digit.
 */
public class Solution_258 {

    /**
     *
     * @param num a non-negative integer
     * @return one digit number
     * For example: Given num = 38, the process is: 3 + 8 = 11, 1 + 1 = 2.
     * Since 2 only has one digit, return it.
     */

    public static int addDigit(int num) {
        while (num > 9) {
            int sum = 0;
            String stringNum = Integer.toString(num);
            for (int i = 0; i < stringNum.length(); i++) {
                char charDigit = stringNum.charAt(i);
                sum += Character.getNumericValue(charDigit);
            }
            num = sum;
        }
        return num;
    }

    /**
     * Mathematical Approach: To calculate the digital root, we use congruence formula
     * Link: https://en.wikipedia.org/wiki/Digital_root
     */
    public static int addDigit2(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        else return num % 9;

    }

    public static void main(String[] args) {
        int num = 92;
        System.out.println(addDigit(num));

        System.out.println(addDigit2(num));
    }


}
