package CS112.test.CS112_Summer_I.hw3;

/* File: BigInt.java
 * Date: 4/31/17
 * Author:  Wayne Snyder (snyder@bu.edu)
 * Class: CS 112, Summer I, 2017
 * Purpose: This is the template for HW03, Problem B.2. You must fill in the method stubs as
 *          described in the assignment.
 */



import java.util.Arrays;                    // so that we can print out arrays using Arrays.toString(...)

public class BigInt  {


    public static final int SIZE = 20;      // length of arrays representing big ints

    public static final int[] NaBI = { -1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };  // error value

    public static int[] intToBigInt(int n) {

        if (n < 0) return NaBI;

        int[] bigInt = new int[SIZE];
        int counter = SIZE - 1;
        while (n != 0) {
            int mod = n % 10; //Extract the least significant number
            n /= 10; //Shift
            bigInt[counter--] = mod;
        }


        return bigInt;
    }

    public static int[] stringToBigInt(String s) {

        if (s.length() > SIZE) return NaBI;
        int[] bigInt = new int[SIZE];


        int counter = SIZE - 1;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return NaBI;
            }
            bigInt[counter--] = s.charAt(i) - '0';
        }
        return bigInt;
    }


    public static String bigIntToString(int[] A) {

        String s = "";
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 9 || A[i] < 0) {
                return "NaBI";

            }

            s += A[i];
        }


        int counter = 0;
        while (counter < SIZE && s.charAt(counter) == '0') {
            counter++;
        }

        if (counter == 20) return "0";

        return s.substring(counter);

    }

    // Compare the two big integers A and B and return -1, 0, or 1, depending
    //  on whether A < B, A == B, or A > B, respectively.

    public static int compareTo(int[] A, int[] B) {

        for (int i = 0; i < SIZE; i++) {
            if (A[i] < B[i]) return -1;
            if (A[i] > B[i]) return 1;
            else continue;
        }

        return 0;
    }

    // Add two big integers and return a new array representing their sum; if the result overflows,
    //                                         i.e., contains more than SIZE digits, return NaBI.

    public static int[] add(int[] A, int[] B) {

        // your code here
        int carry = 0;
        int[] sum = new int[20];
        for (int i = SIZE - 1; i >= 0 ; i--) {
            int tmp = (A[i] + B[i] + carry);
            sum[i] = tmp % 10;
            carry = tmp / 10;
            if (i == 0 && carry != 0) return NaBI;

        }
        return sum;    // just to get it to compile
    }


// Unit Test: Here is where we put tests to verify that this class works properly; it is
// not used except for debugging and testing purposes, and will be ignored when you use
// this class as as a static library.

    public static void main(String [] args) {

        System.out.println("\nUnit Test for BigInt Library.\n");

        // Note that we may call the methods without the prefix BigInt.
        // because we are testing from inside the class; if you call these
        // methods from outside the class you must use the prefix, e.g., BigInt.bigIntToString(A).

        System.out.println("Test 1: Should be\n1234567");
        int[] A = { 0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7 };
        System.out.println(bigIntToString(A));
        System.out.println();

        System.out.println("Test 2: Should be\n0");
        int[] B = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
        System.out.println(bigIntToString(B));
        System.out.println();

        System.out.println("Test 3: Should be\nNaBI");
        int[] C = { 0,0,0,0,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
        System.out.println(bigIntToString(C));
        System.out.println();

        System.out.println("Test 4: Should be\n[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7]");
        A = intToBigInt( 1234567 );
        System.out.println(Arrays.toString(A));
        System.out.println();

        System.out.println("Test 5: Should be\n1234567");
        System.out.println(bigIntToString(A));
        System.out.println();

        System.out.println("Test 6: Should be \n0");
        B = intToBigInt( 0 );
        System.out.println(bigIntToString(B));
        System.out.println();

        System.out.println("Test 7: Should be\nNaBI");
        C = intToBigInt( -4 );
        System.out.println(bigIntToString(C));
        System.out.println();

        System.out.println("Test 8: Should be\n[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 4, 1, 5, 9, 2]");
        System.out.println(Arrays.toString( stringToBigInt( "3141592" ) ));
        System.out.println();

        System.out.println("Test 9: Should be\n0");
        System.out.println(bigIntToString( stringToBigInt( "0" ) ));
        System.out.println();

        System.out.println("Test 10: Should be \nNaBI");
        System.out.println(bigIntToString( stringToBigInt( "234h56" ) ));
        System.out.println();

        System.out.println("Test 11: Should be\nNaBI");
        System.out.println(bigIntToString( stringToBigInt( "23456379238472937829384272939472937429374" ) ));
        System.out.println();

        System.out.println("Test 12: Should be\n0");
        System.out.println(compareTo( stringToBigInt("12375"), stringToBigInt("12375")));
        System.out.println();

        System.out.println("Test 13: Should be\n-1");
        System.out.println(compareTo( stringToBigInt("12375"), stringToBigInt("12378")));
        System.out.println();

        System.out.println("Test 14: Should be\n1");
        System.out.println(compareTo( stringToBigInt("12395"), stringToBigInt("12375")));
        System.out.println();

        System.out.println("Test 15: Should be\n0");
        System.out.println(compareTo( stringToBigInt("0"), stringToBigInt("0")));
        System.out.println();

        System.out.println("Test 16: Should be\n-1");
        System.out.println(compareTo( stringToBigInt("0"), stringToBigInt("12375")));
        System.out.println();

        System.out.println("Test 17: Should be\n1");
        System.out.println(compareTo( stringToBigInt("111"), stringToBigInt("0")));
        System.out.println();

        System.out.println("Test 18: Should be\n123456789123456789");
        System.out.println(bigIntToString(add( stringToBigInt("36182736036182736"), stringToBigInt("87274053087274053"))));
        System.out.println();

        System.out.println("Test 19: Should be\n3141592653598");
        System.out.println(bigIntToString(add( stringToBigInt("0"), stringToBigInt("3141592653598"))));
        System.out.println();

        System.out.println("Test 20: Should be\n10000000000000000000");
        System.out.println(bigIntToString(add( stringToBigInt("9999999999999999999"), stringToBigInt("1"))));
        System.out.println();

        System.out.println("Test 21: Should be\nNaBI");
        System.out.println(bigIntToString(add( stringToBigInt("99999999999999999999"), stringToBigInt("1"))));
        System.out.println();


    }


}