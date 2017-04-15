package Basics.LeetCode;

/**
 * Created by davidzhou on 4/14/17.
 * 404 Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/#/description
 */
public class Solution_404 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * TODO: Pay attention to corner case
     * @param root
     * @return the sum of left leaves of a tree
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        if (root.left == null) return sumOfLeftLeaves(root.right);
        if (root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left);


    }
}
