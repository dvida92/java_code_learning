package Basics.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by davidzhou on 4/12/17.
 * 145.Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/#/description
 */
public class Solution_145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;

        }
    }

    /**
     * Iterative Version 需要理解并实现
     * @param root
     * @return
     * http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {

        }
        return null;

    }

    /**
     * Recursive Version
     * @param root
     * @return a linked list of elements in postorder for a subtree rooted at root
     */
    public List<Integer> postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<Integer> left = (LinkedList<Integer>) postorderTraversalRec(root.left);
        LinkedList<Integer> right = (LinkedList<Integer>) postorderTraversalRec(root.right);
        for (int i = 0; i < left.size(); i++) {
            Integer integer = left.get(i);
            linkedList.add(integer);
        }

        for (int i = 0; i < right.size(); i++) {
            Integer integer = right.get(i);
            linkedList.add(integer);
        }

        linkedList.add(root.val);
        return linkedList;
    }

    public static void main(String[] args) {

    }
}
