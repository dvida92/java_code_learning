package Basics;

/**
 * Recursion
 */
public class Test9 {

    int f(int n) {
        if(n == 1) {
            return 1;
        }
        else {
            return n * f(n - 1);
        }
    }

    public static void main(String[] args) {
        Test9 t = new Test9();
        System.out.println(t.f(10));
    }
}
