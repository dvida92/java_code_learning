package Basics.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by davidzhou on 4/20/17.
 * 501.Find Mode in Binary Search Tree
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/#/description
 */
public class Solution_501 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;


    /**
     * A naive approach that doesn't work
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        //Subtract the elements from the bst in in-order order
        LinkedList<Integer> nodes = inOrder(root);

        HashMap<Integer, Integer> tally = new HashMap<>();

        for (int i = 0; i < nodes.size(); i++) {
            Integer integer = nodes.get(i);
            if (tally.containsKey(integer)) {
                int oldVal = tally.get(integer);
                tally.put(integer, oldVal);
            } else {
                tally.put(integer, 1);
            }
        }

        return null;

    }
    /**
     * Traverse the BST rooted at root and extract the elements to a linked list
     * @param root
     * @param
     * @return
     */
    private LinkedList<Integer> inOrder(TreeNode root) {
        LinkedList<Integer> answer = new LinkedList<>();
        if (root == null) {
            return answer;
        }

        answer.addAll(inOrder(root.left));
        answer.add(root.val);
        answer.addAll(inOrder(root.right));
        return answer;
    }






}
