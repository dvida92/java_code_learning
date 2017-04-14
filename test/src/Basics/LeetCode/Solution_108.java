package Basics.LeetCode;

import java.util.Arrays;

/**
 * Created by davidzhou on 4/13/17.
 * 108.Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution_108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * TODO:redo
     * Returns a height balanced BST
     * @param nums
     * @return
     * Reference: http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid - 1);
        root.right = helper(nums, mid + 1, high);

        return root;
    }
}
