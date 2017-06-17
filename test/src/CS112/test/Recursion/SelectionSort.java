package CS112.test.Recursion;

import java.util.Arrays;

/**
 * Created by davidzhou on 6/12/17.
 */
public class SelectionSort {

    public static void selectionSort(int[] nums) {
        selectionSort(nums, 0, nums.length - 1);
    }

    /**
     * Recursive Implementation of Selection Sort
     * @param nums
     * @param low
     * @param high
     */
    private static void selectionSort(int[] nums, int low, int high) {
        if (low < high) {
            int minSoFar = low;
            for (int i = low; i < nums.length; i++) {
                if (nums[minSoFar] > nums[i]) {
                    minSoFar = i;
                }
            }

            int tmp = nums[low];
            nums[low] = nums[minSoFar];
            nums[minSoFar] = tmp;
            selectionSort(nums, low + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
