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
     * Determine if every node's two subtrees are balanced
     * Use a helper method to calculate the max depth of a sub-tree
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

//        if (root.left != null && root.right == null) {
//            if (maxDepth(root.left) == 1) return true;
//            return false;
//        }
//
//        if (root.left == null && root.right != null) {
//            if (maxDepth(root.right) == 1) return true;
//            return false;
//        }

        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);


    }

    /**
     *
     * @param root
     * @return The max depth of a tree
     */
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
