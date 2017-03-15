package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 3/14/17.
 */
public class Solution_threeSum {

    //BF Alg
    public static int[] bfThreeSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length ; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == target) {
                        return new int[] {i, j, k};
                    }
                }

            }
        }
        return new int[] {-1, -1, -1};
    }


    public static void main(String[] args) {

        int []numbers = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(bfThreeSum(numbers, 8)));


    }
}
