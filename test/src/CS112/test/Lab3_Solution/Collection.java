package CS112.test.Lab3_Solution;

/* File: Collection.java
 * Authors: Wayne Snyder and Abbas Attarwala
 * Date: June 6th, 2017
 * Purpose: This is part of the code distribution to Lab 3, CS 112, Summer I;
 *          it is an abstract class provided to the students for creating
 *          Stack, Queue, and PQueue subclasses.
 */


// In order to extend this abstract class, you need to provide implementations for
// all the abstract methods in the class. All non-abstract members will be inherited
// as they are written here.

public abstract class Collection {        // 1. Abstract classes cannot be instantiated, but they can be subclassed.

    protected int SIZE = 10;              // protected means it is visible in subclasses only

    protected int[] A = new int[SIZE];

    public abstract void insert(int n);   // abstract means any subclass MUST override this with an actual definition

    public abstract int remove();         // 2. An abstract method is a method that is declared without an implementation
                                            //  Only an abstract class has abstract methods
    public abstract int peek();

    public abstract int size();

    public boolean isEmpty() {           // this will be inherited by any subclass
        return (size() == 0);
    }

    public abstract String toString();

}
