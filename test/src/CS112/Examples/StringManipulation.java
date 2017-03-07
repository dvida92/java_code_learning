package CS112.Examples;

/**
 * Created by davidzhou on 3/4/17.
 */
public class StringManipulation {
    public static void main(String[] args) {
        String s = "abcde";

        System.out.println(s.length());
        System.out.println(s.charAt(2));
        System.out.println(s.indexOf('b')); //first occurrence of 'b'
        System.out.println(s.concat("a"));
        System.out.println(s.substring(1,s.length())); //substring of this string
        System.out.println(s.equals("abcde")); //compare two strings
        System.out.println(s.compareTo("abcde"));

    }
}
