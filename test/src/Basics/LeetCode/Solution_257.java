package Basics.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidzhou on 4/14/17.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}



public class Solution_257 {


    /**
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new LinkedList<>();
        if (root == null) return ret;
        if (root.left == null && root.right == null) {
            ret.add(root.val + "");
            return ret;
        }
        for (String s : binaryTreePaths(root.left)) {
            ret.add(root.val + "->" + s);
        }
        for (String s : binaryTreePaths(root.right)) {
            ret.add(root.val + "->" + s);
        }

        return ret;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> list = binaryTreePaths(root);
        System.out.println(list);

    }

}
