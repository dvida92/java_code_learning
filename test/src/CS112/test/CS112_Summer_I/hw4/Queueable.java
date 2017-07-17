package CS112.test.CS112_Summer_I.hw4;

/* File: Queueable.java
 * Date: 9/27/16
 * Author:  Wayne Snyder (waysnyder@gmail.com)
 * Class: CS 112, Fall 2016
 * Purpose: Part of solution for Lab 04, Problem 2
 */

public interface Queueable {

    // Insert a new element on the rear of the queue
    // If stack is full, resizes

    public void enqueue(int n);

    // Remove and return the front element of the queue; move everything over to the left one slot
    // Note: Does not check for underflow

    public int dequeue();

    // Return front element of the queue without removing it
    // Note: Does not check for underflow

    public int peek();

    // Return the number of integers in the queue

    public int size();

    // Return true iff there are no elements in the queue

    public boolean isEmpty();

}