package Basics;

/**
 * Experimenting with Class
 * Class name should use capital Letter: e.g. Dog, Person
 * Other variables should use this format: e.g. myLastNameIsZhou
 */

public class Test2 {
    public int i;
    public int j;

    //Default Constructor: "new" will use this constructor, default value for i, j =0
    Test2() {

    }

    //Another constructor: "new" will use this constructor
    Test2(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static void main(String[] args) {
        Test2 t1 = new Test2(); //t1 is a pointer that points to the memory when "new" in the heap segment
        Test2 t2 = new Test2(); //Analysis of RAM: t1 and t2 are in code segment, whereas t1.i,t1.j,t2.i and t2.j are in heap segment.
        Test2 t3 = new Test2(1,2);
        System.out.println(t1.i);
        System.out.println(t2.j);
        System.out.println(t3.i + t3.j);
    }



}
