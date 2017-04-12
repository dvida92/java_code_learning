package Basics.LeetCode;

import java.util.Map;

/**
 * Created by davidzhou on 4/11/17.
 * Reverse Integer
 * https://leetcode.com/problems/reverse-integer/#/description
 */
public class Solution_7 {

    public static int reverse(int x) {

        boolean flag = false; //Flag denotes if integer x is negative
        if (x < 0) {
            //Should consider this corner case
            if (x == - Math.pow(2, 31)) return 0;
            x = Math.abs(x);
            flag = true;
        }

        String s = Integer.toString(x);
        char[] charArray = s.toCharArray();
        char[] newCharArray = new char[charArray.length];
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            newCharArray[charArray.length - 1 - i] = c;
        }

        String newString = new String(newCharArray);
        long reversedNum = Long.parseLong(newString);
        if (flag) {
            if (reversedNum <= Math.pow(2,31)) return (int) -reversedNum;
        } else {
            if (reversedNum < Math.pow(2, 31)) return (int) reversedNum;
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));

    }
}
