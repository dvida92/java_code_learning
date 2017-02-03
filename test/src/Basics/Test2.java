package Basics;

/**
 * Enhanced for loop.
 */

public class Test2 {
    public static void main(String[] args) {
        int [] number = {10, 20, 30, 40, 50};

        //CAUTION: Unable to operate on the elements in number []
        for(int i : number) {
            i++;
            System.out.println(i);

        }

        for(int i: number ) {
            System.out.println(i);

        }
    }
}
