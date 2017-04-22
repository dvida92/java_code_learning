package Basics.LeetCode;

import java.util.Stack;

/**
 * Created by davidzhou on 4/20/17.
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/#/description
 */
public class Solution_173 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {

        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {

            return false;
        }

        /** @return the next smallest number */
        public int next() {

            return 0;
        }
    }

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
