package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 4/15/17.
 * 88 Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/#/description
 */
public class Solution_88 {





    /**
     * Switch bits during the merge process
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointerM = 0;
        int pointerN = 0;
        while (m != 0 && n!= 0) {
            if (nums1[pointerM] >= nums2[pointerN]) {
                for (int i = pointerM + m; i > pointerM ; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[pointerM++] = nums2[pointerN++];
                n--;
            } else {
                pointerM++;
                m--;
            }
        }

        while (n != 0) {
            nums1[pointerM++] = nums2[pointerN++];
            n--;
        }


    }

    /**
     * A more efficient way to merge two lists
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else{
                nums1[p3--] = nums2[p2--];
            }
        }

        while (p2 >= 0) {
            nums1[p3--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[]nums1 = {4,5,6,0,0,0};
        int[]nums2 = {1,2,3};
        merge(nums1,3, nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
