package Basics.LeetCode;

/**
 * Reverse String
 */
public class Solution_344 {

    public String reverseString(String s) {

        char [] c1 = s.toCharArray();
        char [] c2 = new char[c1.length];

        for (int i = 0; i < c1.length; i++) {
            c2[c1.length - 1 - i] = c1[i];
        }

        String s1 = String.valueOf(c2);

        return s1;
    }


    public static void main(String[] args) {
        Solution_344 sss = new Solution_344();
        System.out.println(sss.reverseString("Hello"));
    }
}
