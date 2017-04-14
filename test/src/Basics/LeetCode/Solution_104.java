package Basics.LeetCode;

/**
 * Created by davidzhou on 4/13/17.
 * 104.Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/#/description
 *
 */
public class Solution_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Find the max depth of a tree: the number of nodes along the
     * longest path from the root node down to the farthest leaf node.
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
