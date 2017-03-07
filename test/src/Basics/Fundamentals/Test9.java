package Basics.Fundamentals;

/**
 * Recursion
 */
public class Test9 {

    static int f(int n) {
        if(n == 1) {
            return 1;
        }
        else {
            return n * f(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Test9.f(10));
    }
}
