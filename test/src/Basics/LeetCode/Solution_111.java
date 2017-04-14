package Basics.LeetCode;

/**
 * Created by davidzhou on 4/13/17.
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description
 */
public class Solution_111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
