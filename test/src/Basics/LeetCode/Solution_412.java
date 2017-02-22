package Basics.LeetCode;

import java.util.LinkedList;


/**
 * 412 Fizz Buzz  需要用list代替linkedlist从写
 */
public class Solution_412 {

    public static String [] fizzBuzz(int n) {

        LinkedList<String> l = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 != 0) {
                l.add("Fizz");
            } else if(i % 3 != 0 && i % 5 == 0) {
                l.add("Buzz");

            } else if(i % 15 == 0) {
                l.add("FizzBuzz");
            } else {
                l.add(Integer.toString(i));
            }
        }

        String []L = l.toArray(new String[0]);

        return L;

    }

    public static void main(String[] args) {
        String []s1 = Solution_412.fizzBuzz(15);
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
    }

}

