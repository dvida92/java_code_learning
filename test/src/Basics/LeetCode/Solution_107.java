package Basics.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by davidzhou on 4/13/17.
 * 107.Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
 */
public class Solution_107 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < currentLevel; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                tmp.add(queue.poll().val);
            }
            result.addFirst(tmp);
        }

        List<List<Integer>> reverseResult = new LinkedList<>();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> integers =  result.get(i);
            reverseResult.add(integers);
        }

        return reverseResult;

    }
}
