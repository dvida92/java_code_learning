package Basics.Fundamentals;

/**
 *  Recursion
 */
public class Test15 {

    public static void main(String[] args) {

        System.out.println(f1(40));
        System.out.println(f2(40));

    }

    //Repetitive Substitute
    public static int f1(int n) {
        int [] f = new int[n];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i-1] + f[i - 2];
        }
        return f[n-1];
    }


    //Recursive Edition
    public static int f2(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        else {
           return f2(n - 1) + f2(n - 2);
        }

    }







}
