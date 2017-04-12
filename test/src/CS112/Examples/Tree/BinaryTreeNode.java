package CS112.Examples.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by davidzhou on 4/4/17.
 * Midterm Review by Abbas Attawarla
 */
public class BinaryTreeNode {

    public int data;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;


    //Print the tree "In Order"
    //http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
    public String toString() {
        if (this.leftChild != null && this.rightChild != null) {
            return this.leftChild.toString() + Integer.toString(data) + this.rightChild.toString();
        } else if (this.leftChild != null) {
            return this.leftChild.toString() + Integer.toString(data) ;
        } else if (this.rightChild != null) {
            return this.rightChild.toString() + Integer.toString(data);
        } else {
            return Integer.toString(this.data);
        }

    }

    //Count the # of full node: No recursion allowed
    public int countNumberOfFullNode(BinaryTreeNode head) {
        int counter = 0;
        if (head == null) {
            return counter;
        }

        //Using a linkedList as a queue(FIFO)
        LinkedList<BinaryTreeNode> q = new LinkedList<>();
        q.add(head);

        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();

            if (tmp.rightChild != null & tmp.leftChild != null) {
                counter++;
                q.add(tmp.rightChild);
                q.add(tmp.leftChild);
            }

            if (tmp.rightChild != null) {
                q.add(tmp.rightChild);
            }

            if (tmp.leftChild != null) {
                q.add(tmp.leftChild);
            }
        }

        return counter;

    }


    //Returns a String of the binary tree in pre order; No recursion; instead use a stack
    public String preorderTraverse(BinaryTreeNode head) {
        Stack<BinaryTreeNode> ss = new Stack<>();
        String ret = "";

        if (head == null) return "Empty Tree!";

        if (head.leftChild == null && head.rightChild == null) return Integer.toString(data);

        ss.push(head);

        while (!ss.isEmpty()) {
            BinaryTreeNode tmp = ss.pop();
            if (tmp.leftChild != null && tmp.rightChild != null) {
                ret += tmp.data;
                ss.push(tmp.rightChild);
                ss.push(tmp.leftChild);
            } else if (tmp.leftChild != null) {
                ret += tmp.data;
                ss.push(tmp.leftChild);
            } else if (tmp.rightChild != null) {
                ret += tmp.data;
                ss.push(tmp.rightChild);

            } else {
                ret += tmp.data;
            }
        }

        /*
        //A better while loop
        while (!ss.isEmpty()) {
            BinaryTreeNode tmp = ss.pop();
            ret += tmp.data;
            if (tmp.rightChild != null) {
                ss.push(tmp.rightChild);
            }
            if (tmp.leftChild != null) {
                ss.push(tmp.leftChild);
            }
        }
        */

        return ret;

    }



}
