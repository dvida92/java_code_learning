package Basics.Debug;

/**
 * Some errors result from primitive types (integer nad real number)
 */
public class Corner_Case {
    public static void main(String[] args) {

        //Case 1: The following expressions generate truncated integers
        int a = 1;
        int b = 2;
        System.out.println("1.Integer Division returns " +
                "a truncated integer: " + a/b);

        double x = 1 / 5;
        System.out.println("1.1Integer Division: 1 and 5 are both integers:" +
                " " + x);
        //Case 2: Integer Overflow returns a value from somewhere
        // in the legal range but not the right answer
        int c = 2000000000;
        System.out.println("2.Integer overflow: " + c * 2);

        //Case 3
        double sum = 7;
        double n = 0;
        double average = sum/n;
        System.out.println("3.Floating-pint types have several special values: " +
                "Negative_Infinity" + average);

    }
}
