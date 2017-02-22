package Basics;

/**
 * Manipulation on String
 */
public class Test19 {

    public static void main(String[] args) {
        String s1 = "abcd";
        System.out.println(s1.charAt(0));
        System.out.println(s1.length());
        System.out.println(Integer.toBinaryString(1073741824));
        System.out.println("D" + s1);
        System.out.println(s1 + "D");

        s1 = "d" + s1;
        System.out.println(s1.charAt(4));
    }
}
