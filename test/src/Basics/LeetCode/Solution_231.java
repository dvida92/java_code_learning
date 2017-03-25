package Basics.LeetCode;

/**
 * Created by davidzhou on 3/21/17.
 * 231 Power of Two
 * https://leetcode.com/problems/power-of-two/#/description
 */
public class Solution_231 {

    /**
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n == 0 ) return false;
        int number = n;
        while (number % 2 == 0) {
            number /= 2;
        }

        //TODO Reduce Redundancy
        if (number == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(1)); //True!
        System.out.println(isPowerOfTwo(0));
    }
}
