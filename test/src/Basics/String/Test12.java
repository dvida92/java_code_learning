package Basics.String;

/**
 *  Class: String - StackParseString "compareTo" method
 */
public class Test12 {


    public static void main(String[] args) {
        String s1 = "aaaa";
        String s2 = "bbbb";
        String s3 = "cccc";
        String s4 = "adjkjk";
        String s5 = "bc";

        System.out.println(s2.compareTo(s1)); //Output is positive because parameter s1 is lexicographically greater than s2
        System.out.println(s2.compareTo(s3)); //Output is negative because parameter s3 is less than s2
        System.out.println(s4.compareTo(s5));  //Bottom Line: 可以理解成每个key按字典编排顺序排序，在前面的字符串与其后页的字符串比较，返回值大于零。
    }




}
