package Basics.LeetCode;

import java.util.Arrays;

/**
 * 167 Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 * Related problem: Three Sum
 */
public class Solution_167 {

    /**
     * Perform binary search on a sub array in a for loop. Running time O(nlogn)
     * @param numbers contains all numbers sorted in ascending order
     * @param target two numbers in the array that add up to this target value
     * @return  two indices of the two numbers
     * Given: each input have exactly one solution and no element can be used
     * twice; Duplicate elements exist.
     * Example: numbers = {2, 7, 11, 15}, target = 9
     * Output: index1 = 1, index2 = 2 && index1 < index2 && indices are not zero-based.
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int []subArray = Arrays.copyOfRange(numbers, i + 1, numbers.length);
            int index = Arrays.binarySearch(subArray, target - numbers[i]);
            if (index >= 0) {
                return new int[] {i + 1, index + i + 1 + 1}; //plus i to compensate for subArray's index

            }
        }
        throw new IllegalArgumentException("Unreachable!");
    }

    /**
     * Simplified Version only good for two numbers' sum; Running time: O(n)
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) return new int[] {low + 1, high + 1};
            else if (sum > target) high--;
            else low++;
        }
        throw new IllegalArgumentException("Unreachable!");
    }


    //Test Cases
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,4,9,56,90};
        int target = 8;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
        System.out.println(Arrays.toString(twoSum2(numbers, target)));
    }
}
