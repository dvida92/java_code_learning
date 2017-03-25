package Basics.LeetCode;

/**
 * Created by davidzhou on 3/20/17.
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/#/description
 */
public class Solution_226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
