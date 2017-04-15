package Basics.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidzhou on 4/14/17.
 * 144.Binary Tree Pre-order Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/#/description
 */
public class Solution_144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * TODO:Iterative Approach
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIter(TreeNode root) {

        return null;
    }

        /**
         * Recursive Method
         * TODO: Use addAll to merge two linked list
         * @param root
         * @return
         */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Integer> ret = new LinkedList<>();
        ret.add(root.val);
        ret.addAll(preorderTraversal(root.left));
        ret.addAll(preorderTraversal(root.right));

        return ret;
    }
}
