package Basics.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by davidzhou on 4/22/17.
 * 225.Implement Stack using Queues
 */
public class Solution_225 {


    public Deque<Integer> queue;

    /** Initialize your data structure here. */
    public Solution_225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}
