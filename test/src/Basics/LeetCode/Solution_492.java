package Basics.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  492.Construct the Rectangle
 */
public class Solution_492 {

    /**
     * Brute Force Algorithm
     * @param area positive integer that is less than 10^7
     * @return two positive integers:length L and width W and L >= W
     * For example: given target area 4, all the possible ways to construct it are
     * [1,4], [2,2], [4,1]; [2,2] is optimal because the difference between the
     * two numbers is the smallest.
     */
    public static int[] outputLengthWidth1(int area) {
        int difference = area;
        int optimalLength = area;
        for (int length = 1; length <= area; length++) {  //Running time: O(n)
            if (area % length == 0) {
                int width = area / length;
                if (length >= width && difference > length - width) {
                    difference = length - width;
                    optimalLength = length;
                }
            }
        }
        return new int[] {optimalLength, area / optimalLength};
    }

    /**
     * A better way that runs in the square root of n : O(sqrt(n))
     *
     */
    public static int [] outputLengthWidth2(int area) {
        int length = (int)Math.sqrt(area);
        if (area % length != 0) length++;
        return new int[] {length, area / length};
    }

    //Tests
    public static void main(String[] args) {
        System.out.println(Arrays.toString(outputLengthWidth1(4)));

        System.out.println(Arrays.toString(outputLengthWidth2(4)));
    }



}
