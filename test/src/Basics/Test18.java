package Basics;

import java.util.Arrays;

/**
 *  Command Line Argument
 */
public class Test18 {
    public static void main(String[] args) {
        int [] a = new int[9];
        for (int i = 0; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);

        }

        Test18.bubbleSort(a);


        for (int i = 0; i < a.length ; i++) {
            System.out.println(a[i]);
        }
    }

    static void bubbleSort(int [] a) {
        boolean flag = false;
        for (int i = 0; !flag && i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if(a[j] > a[j + 1]) {
                    int tmp = a[j+1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }

            }

        }

    }

}
