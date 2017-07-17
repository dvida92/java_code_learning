package CS112.test.CS112_Summer_I.Recursion;

/**
 * Created by davidzhou on 6/12/17.
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        return isPalindromeUtil(s, 0, s.length() - 1);
    }


    /**
     * Recursive Implementation: return if a string (range: low - high) is a palindrome
     * @param s
     * @param low
     * @param high
     * @return
     */
    private static boolean isPalindromeUtil(String s, int low, int high) {
        if (low == high || low > high) return true; //Base Case

        return s.charAt(low) == s.charAt(high) && isPalindromeUtil(s, low + 1, high - 1);  //Recursive Case
    }


    public static void main(String[] args) {
        String s = "apple";
        System.out.println(isPalindrome(s));

    }
}


