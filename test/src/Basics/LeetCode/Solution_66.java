package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 4/15/17.
 * 66.Plus One
 * https://leetcode.com/problems/plus-one/#/description
 */
public class Solution_66 {


    /**
     *
     * @param digits
     * @return
     */
    public static int[] pulsOne(int[] digits) {
        int length = digits.length;
        boolean flag = false;
        for (int i = length - 1; i >= 0 ; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else{
                digits[i]++;
                flag = true;
                break;
            }
        }

        if (!flag){
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,9,9,9,9};
        int[] nums2 = {9,9,9,9,9};
        int[] nums3 = {0};
        int[] nums4 = {9};
        System.out.println(Arrays.toString(pulsOne(nums1)));
        System.out.println(Arrays.toString(pulsOne(nums2)));
        System.out.println(Arrays.toString(pulsOne(nums3)));
        System.out.println(Arrays.toString(pulsOne(nums4)));


    }
}
