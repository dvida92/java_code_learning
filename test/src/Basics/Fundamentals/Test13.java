package Basics.Fundamentals;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  Test "Linked List"
 */
public class Test13 {

    public static void main(String[] args) {
        LinkedList <String> l1 = new LinkedList<String>();

        l1.add("Harry");
        l1.add("David");
        l1.add("Tom");

        String [] array = l1.toArray(new String[0]);


        System.out.println("The converted array is: ");
        System.out.println(Arrays.toString(array));



    }



}
