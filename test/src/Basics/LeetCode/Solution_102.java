package Basics.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by davidzhou on 4/13/17.
 * 102.Binary Tree level order traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
 */
public class Solution_102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * TODO: 自己重做
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null) {
            return wrapList;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

}
