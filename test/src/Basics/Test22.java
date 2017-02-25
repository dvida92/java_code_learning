package Basics;

import java.util.Arrays;

/**
 * Created by davidzhou on 2/22/17.
 */
public class Test22 {

    public static void sort(int array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            int tmp = array[min_index];
            array[min_index] = array[i];
            array[i] = tmp;

        }
    }

    public static void main(String[] args) {
        int array[] = {};
        Test22.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
