package Basics.Fundamentals;

/**
 * Enhanced for loop.
 */

public class Test2 {
    public static void main(String[] args) {
        int [] number = {10, 20, 30, 40, 50};

        //CAUTION: 这种loop是只读的，无法修改number数组中的元素
        for(int i : number) {
            i++;
            System.out.println(i);

        }

        for(int i: number ) {
            System.out.println(i);

        }
    }
}
