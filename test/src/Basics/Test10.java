package Basics;

/**
 * Using Assertion
 */
public class Test10 {

    public static void main(String[] args) {
        double a = 2.0e2;
        assert a < 0: "a is positive";  //if the expression is false, the program will terminate and report and error message.
        System.out.println(2.0e2);

    }
}
