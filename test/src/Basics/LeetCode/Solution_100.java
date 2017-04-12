package Basics.LeetCode;

/**
 * Created by davidzhou on 4/11/17.
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/#/description
 */
public class Solution_100 {

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * Given two binary trees, check if they are equal or not
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSameTree(Node root1, Node root2) {

        if (root1 != null && root2 == null) return true;
        if (root1 != null && root2 == null) return false;
        if (root1 == null && root2 != null) return false;

        //Both trees are not empty

        //If both left child and right child exist
        if (root1.value == root2.value) {
            return isSameTree(root1.leftChild, root2.leftChild) && isSameTree(root1.rightChild, root2.rightChild);
        }

        return false;
    }
}
