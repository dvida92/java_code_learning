package Basics.Fundamentals;

/**
 * Experimenting with Class
 * Class name should use capital Letter: e.g. Dog, Person
 * Other variables should use this format: e.g. myLastNameIsZhou
 *
 * What is reference type?
 * RAM: Code segment, Stack segment, Heap segment
 */

public class Test3 {
    public int i;
    public int j;

    //Default Constructor: "new" will use this constructor, default value for i, j =0
    Test3() {

    }

    //Another constructor: "new" with parameters will use this constructor
    Test3(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static void main(String[] args) {
        Test3 t1 = new Test3(); //t1 is a pointer that contains the memory address when "new" create a place in the heap segment
        Test3 t2 = new Test3(); //Analysis of RAM: t1 and t2 are in stack segment, whereas t1.i,t1.j,t2.i and t2.j are in heap segment.
        Test3 t3 = new Test3(1,2);
        System.out.println(t1.i);
        System.out.println(t2.j);
        System.out.println(t3.i + t3.j);
    }



}
