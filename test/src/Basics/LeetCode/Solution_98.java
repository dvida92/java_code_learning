package Basics.LeetCode;

import java.util.LinkedList;

/**
 * Created by davidzhou on 4/18/17.
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/#/description
 */
public class Solution_98 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * TODO: FIX BUG 1.Recursion
     * Determine if a tree is Binary Search Tree
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.right != null) {
            if (root.val > root.left.val && root.val < root.right.val){
                return isValidBST(root.left) && isValidBST(root.right);
            }
            return false;
        }

        if (root.left == null && root.right != null) {
            if (root.val < root.right.val) {
                return isValidBST(root.right);
            }
            return false;
        }

        if (root.right == null && root.left != null) {
            if (root.val > root.left.val) {
                return isValidBST(root.left);
            }
            return false;
        }

        return true;
    }


    /**
     * 2. Determine if a tree is BST: In-order Traversal
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        inOrderTraversal(root, linkedList);
        for (int i = 0; i < linkedList.size() - 1; i++) {
            TreeNode integer = linkedList.get(i);
            TreeNode integer1 = linkedList.get(i + 1);
            if (integer.val >= integer1.val) return false;
        }
        return true;
    }

    /**
     * In-order traversal to extract the element from the tree to linked list
     * @param root
     * @param linkedList
     */
    private void inOrderTraversal(TreeNode root, LinkedList<TreeNode> linkedList) {

        if (root == null) return;
        inOrderTraversal(root.left, linkedList);
        linkedList.add(root);
        inOrderTraversal(root.right, linkedList);
    }

}
