package Basics.Class_and_Inheritance.Interface;

/**
 * Demonstrate how to use Interface
 */
public class Driver {

    public static void main(String[] args) {
        twoD ob = new twoD();
        for (int i = 0; i < 5; i++) {
            System.out.println("Next value is " + ob.getNext());
        }
    }
}
