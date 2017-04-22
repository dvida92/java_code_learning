package Basics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *  Common Shortcuts illustrated in main method
 * Created by davidzhou on 4/9/17.
 */
public class Intellij_Key_Shortcut {

    /**
     * IntelliJ Template: Iterator
     * Created by davidzhou on 4/10/17.
     */
    private class test {
        private int[] arrayInt;
        private LinkedList<String> linkedList;
        private HashSet<Integer> hashSet;


        public test() {
            this.hashSet = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                hashSet.add(i);
            }

            this.linkedList = new LinkedList<>();
            for (int i = 0; i < 10; i++) {
                linkedList.add("Hello");
            }

            this.arrayInt = new int[10];
            for (int i = 0; i < arrayInt.length; i++) {
                arrayInt[i] = i;
            }

        }

        public void printArray() {
            //Command to iterate an array: itar
            for (int i = 0; i < arrayInt.length; i++) {
                int num = arrayInt[i];
                System.out.println("i1 = " + num);
            }

            //Command to iterate element in SDK 1.5 Style: iter
            for (int num : arrayInt) {
                System.out.println("num = " + num);
            }
        }

        public void printLinkedList() {
            //Command to iterate a list: itli
            for (int i = 0; i < linkedList.size(); i++) {
                String s = linkedList.get(i);
                System.out.println("s = " + s);
            }

        }

        public void printSet() {
            //Command to iterate a set: itco
            for (Iterator<Integer> iterator = hashSet.iterator(); iterator.hasNext(); ) {
                Integer next = iterator.next();
                System.out.println("next = " + next);
            }

        }

        public void testItit() {
            LinkedList<String> ll = new LinkedList<>();
            ll.add("haha");
            ll.add("lol");
            ll.add("wow");
            Iterator<String> iter = ll.iterator();
            //Iterate elements: itit
            while (iter.hasNext()) {
                String next =  iter.next();

            }
        }

    }


    public static void main(String[] args) {

        //Navigation
        //Move to the beginning or end of a line: command + arrow(left/right)
        //Move to next word: option + arrow(left/right)
        //Move cursor: ctrl + n / ctrl + p
        //Move cursor to matching brace: Ctrl + M

        //Editing
        //Smart Completion: Option + space
        //Complete Statement: shift + command + enter
        //Start a new line: shift + enter
        //Start a new line before current line: option + command + enter
        //Duplicate one line: command + d
        //Delete an entire line: command + delete
        //Move one line down/up: shift + option + arrow keys(up/down)
        //Generate Code: Command + Enter

        //Utility
        //Quick documentation lookup: ctrl + J
        //Quick definition lookup: command + Y
        //Go to declaration: command +B
        //Show Intention Action: Option + Enter
        //Search Everywhere: double-click shift
        //Inheritance relation: ctrl + h
        //Run context configuration(current tab program): ctrl + shift + R
        //Refactor this: ctrl + T


        //Insert Live Template: command + J
        //iter: for each iterator
        //itit: iterator
        //itli: list iterator
        //itar: for loop for array

        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {   //itar
            int num = array[i];
            System.out.println("num = " + num); //soutv

        }

    }
}
