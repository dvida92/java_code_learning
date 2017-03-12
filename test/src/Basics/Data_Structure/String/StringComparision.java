package Basics.Data_Structure.String;

/**
 *  == tests object references, .equals() tests the string values
 *  ALWAYS use the latter one to compare values
 *  Explanation: http://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
 */
public class StringComparision {

    public static void main(String[] args) {
        String s = new String("hello");
        if (s == "hello") System.out.println("Yes");
    }
}
