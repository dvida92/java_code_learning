package CS112.test.CS112_Summer_I.Lab5;

/**
 * Created by davidzhou on 6/21/17.
 */
/* File: IntStack.java
 * Classes: IntStack
 * Date: 11/17/16
 * Class: Boston University CS 112, Fall 2016
 * Author: Wayne Snyder (waysnyder@gmail.com)
 * Purpose: Example of simple array-based stack for Lab 11
 */

public class IntStack  {

    private int [] A = new int[5];

    private int next = 0;                        // location of next available unused slot

    // interface methods

    public void push(int key) throws StackOverFlowException{         // push the key onto the top of the stack
        if (size() >= A.length) throw new StackOverFlowException("Error: stack overflow when pushing ", key);
        A[next++] = key;
    }

    public int pop() throws StackUnderFlowException{            // remove the top integer and return it -- will cause error if empty!
        if (isEmpty()) throw new StackUnderFlowException();
        return A[--next];
    }

    public boolean isEmpty() {
        return (next == 0);
    }

    public int size() {                 // how many integers in the stack
        return next;
    }

    // unit test

    public static void main(String [] args) {

        IntStack S = new IntStack();

        System.out.println("Pushing 5, 9, 9, -3, 31 then popping and printing them out:");
        try{
            S.push(5); S.push(9); S.push(9); S.push(-3); S.push(31);
        } catch (StackOverFlowException e) {
            e.printStackTrace();
        }



        try{
            while(!S.isEmpty()) {
                System.out.println(S.pop());

            }
        } catch(StackUnderFlowException e) {
            e.printStackTrace();
        }


        // this one will cause an underflow error, since the stack is empty!
        System.out.println();
        System.out.println("Popping an empty stack will cause an error:");
        try {
            System.out.println(S.pop());
        } catch (StackUnderFlowException e) {
            System.out.println("Do not pop anymore!");
            System.out.println();
        }

//        System.out.println("I am here!");



        System.out.println("Pushing too many data items will also cause an error:");
        try {
            S.push(5);
            S.push(9);
            S.push(9);
            S.push(-3);
            S.push(31);
            S.push(99);
        } catch (StackOverFlowException e) {
            e.printErrorMessege();
        }



    }
}

// put your class definitions for the exceptions in this file, right here:

class StackUnderFlowException extends Exception {

}


class StackOverFlowException extends Exception {
    public String errorMessage;
    public int n;

    public StackOverFlowException(String s, int n) {
        errorMessage = s;
        this.n = n;
    }

    public void printErrorMessege() {
        System.out.println(errorMessage + n);
    }
}
