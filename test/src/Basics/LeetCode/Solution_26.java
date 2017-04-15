package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 4/12/17.
 * Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
 */
public class Solution_26 {

    public static int removeDuplicates1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int pointer = 1; //How to set pointer properly?
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }




    /**
     * In place with constant memory. However, leetcode doesn't accept my answer since it's not
     * sorted anymore
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        //TODO: corner case
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;


        int head = 0;
        int tail = nums.length - 1;
        while (head < tail && head < nums.length - 1 &&
                tail > 0) {
            if (nums[head] == nums[head + 1]) {
                if (nums[tail] != nums[tail - 1]) {
                    swap(nums, head, tail);
                    head++;
                    tail--;
                } else {
                    while (tail > 0 && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                    if (head == tail) return head + 1;
                    swap(nums, head, tail);
                    head++;
                    tail--;
                }
            } else head++;
        }
        return head + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 7};
        System.out.println("New length:" + removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {3,3,3,3,3,3,3,3,3};
        System.out.println("New length:" + removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));


    }
}
