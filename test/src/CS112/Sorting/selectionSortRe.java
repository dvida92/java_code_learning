package CS112.Sorting;

import java.util.Arrays;

/**
 * Recursion version of selectionSortRe sort
 */
public class selectionSortRe {
    public static void sort(int []array, int index) {
        if (index < array.length) {
                int currentMinIndex = index;
                for (int j = index + 1; j < array.length ; j++) {
                    if (array[currentMinIndex] > array[j]) currentMinIndex = j;
                }
                swap(array, index, currentMinIndex);
                sort(array, index + 1);
            }


    }

    public static void swap(int []array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {7,6,5,4,3,2,1};
        selectionSortRe.sort(a, 0);
        System.out.println(Arrays.toString(a));
    }
}
