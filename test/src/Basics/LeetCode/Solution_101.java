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

    /**
     * Given a binary tree, check whether it is a mirror of itself (Symmetric around its center)
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }


    /**
     * Determine if subtree left and subtree right are symmetric
     * @param left
     * @param right
     * @return
     */
    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) return false;
        return isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);

    }

}
