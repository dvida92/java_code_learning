package Basics.LeetCode;

/**
 * Created by davidzhou on 4/15/17.
 */
public class Solution_35 {

    /**
     * Linear Search in O(n)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertPosition(int[] nums, int target) {
        if (nums.length == 0) throw new IllegalArgumentException();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    /**
     * Binary Search in O(nlogn)
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsertPosition1(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            if (nums[mid] > target) high = mid - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,8,10};
        int nums2 [] = {1,2,3,4,5, 7};

        System.out.println(searchInsertPosition1(nums, 100)
);
        System.out.println(        searchInsertPosition1(nums2, 6)
);
    }
}
