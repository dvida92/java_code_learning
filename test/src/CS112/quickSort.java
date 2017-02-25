package CS112;

import java.util.Arrays;

/**
 * Created by davidzhou on 2/16/17.
 */
public class quickSort {

    public static void swap(int []a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition (int []a, int begin, int end) {
        int i = begin + 1;
        for (int j = begin + 1; j < end; j++) {
            if(a[j] < a[begin]) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, begin, i - 1);
        return i-1;
    }

    public static void sort(int []a, int begin, int end) {
        if(end - begin > 1) {
            int pivot = partition(a, begin, end);
            sort(a, begin, pivot);
            sort(a, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int a[] = {7,6,5,4,3,2,1};
        quickSort.sort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

}
