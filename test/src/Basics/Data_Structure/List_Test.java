package Basics.Data_Structure;


import java.util.ArrayList;
import java.util.List;

/**
 * 1.The difference between an interface and implementation of this interface
 * 2.Know how to use Java API documentation: https://docs.oracle.com/javase/8/docs/api/
 */
public class List_Test {

    public static void main(String[] args) {
        //List is an interface, whereas
        //ArrayList is a class and implementation of List
        List<Integer> list = new ArrayList<>();

        list.add(0, 10);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
}
