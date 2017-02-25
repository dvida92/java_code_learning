package CS112.test;

import java.util.Arrays;

/**
 * Created by davidzhou on 2/23/17.
 */
public class mergeSort {
    public static int partition(int[]a, int begin, int end) {
        int i = begin + 1;
        for (int j = begin + 1; j < end; j++) {
            if (a[j] < a[begin]){
                swap(a, j, i);
                i++;
            }
        }
        swap(a,i-1,begin);
        return i-1;
    }

    public static void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void quickSort(int []a, int begin, int end) {
        if (end - begin > 1) {
            int index = partition(a, begin, end);
            quickSort(a, begin, index);
            quickSort(a, index+1, end);
        }
    }

    public static void main(String[] args) {
        int []a = {5,4,3,2,1};
        quickSort(a,0, a.length);
        System.out.println(Arrays.toString(a));

    }
}
