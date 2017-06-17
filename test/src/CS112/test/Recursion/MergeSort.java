package CS112.test.Recursion;

import java.util.Arrays;

/**
 * Created by davidzhou on 6/12/17.
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums) {
        return mergeSortUtil(nums, 0, nums.length - 1);
    }

    /**
     * Sort elements from low to high in array "nums"
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int[] mergeSortUtil(int[] nums, int low, int high) {
        if (low == high) return new int[] {nums[low]};

        int mid = (low + high) / 2;
        int[] nums1 = mergeSortUtil(nums, low, mid);
        int[] nums2 = mergeSortUtil(nums, mid + 1, high);
        return merge(nums1, nums2);
    }

    /**
     * Merge two sorted arrays nums1 and nums2
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] merge(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length + nums2.length];
        int p = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] <= nums2[p2]) {
                ret[p++] = nums1[p1++];
            } else {
                ret[p++] = nums2[p2++];
            }
        }

        while (p1 < nums1.length) {
            ret[p++] = nums1[p1++];

        }

        while (p2 < nums2.length) {
            ret[p++] = nums2[p2++];

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num = {4,3,2,1};
        System.out.println(Arrays.toString(mergeSort(num)));
    }
}
