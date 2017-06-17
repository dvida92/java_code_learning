package Basics.LeetCode;

/**
 * Created by davidzhou on 5/28/17.
 *
 * 58.Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/#/description
 */
public class Solution_58 {

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;

        if (s.length() == 1) {
            if (s.charAt(0) != ' ')return 1;
            else return 0;
        }

        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index --;
        }


        int counter = 0;
        for(int i = index; i >=0; i--){
            if (s.charAt(i) != ' ') counter ++;
            else return counter;
        }
        return counter;
    }

    public static void main(String[] args) {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }

}
