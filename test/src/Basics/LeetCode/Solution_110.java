package Basics.LeetCode;

/**
 * Created by davidzhou on 4/13/17.
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/#/description
 */
public class Solution_110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * If every node's two subtrees are balanced
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

}
