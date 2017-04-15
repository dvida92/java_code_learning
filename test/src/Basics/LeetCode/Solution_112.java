package Basics.LeetCode;

/**
 * Created by davidzhou on 4/14/17.
 * 112.Path Sum
 * https://leetcode.com/problems/path-sum/#/description
 */
public class Solution_112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * Recursive Method
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
