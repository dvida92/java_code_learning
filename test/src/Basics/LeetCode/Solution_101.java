package Basics.LeetCode;

/**
 * Created by davidzhou on 4/12/17.
 * Symmetric Tree
 */
public class Solution_101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return false;
    }

}
