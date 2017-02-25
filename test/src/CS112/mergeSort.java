package CS112;

import java.util.Arrays;

/**
 * Practice Recursion on merge sort
 */
public class mergeSort {

    public static int[] mergeSort(int []A, int begin, int end) {
        if(begin == end - 1) {
            int[] ret = new int[1];
            ret[0] = A[begin];
            return ret;
        }
        int mid = (begin + end) / 2;
        int []a = mergeSort(A, begin, mid);
        int []b = mergeSort(A, mid, end);
        return merge(a, b);
    }


    public static int[] merge(int []a, int []b) {
        int [] array = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                array[k++] = a[i++];
            } else {
                array[k++] = b[j++];
            }
        }
        while(i < a.length) {
            array[k++] = a[i++];
        }
        while(j < b.length) {
            array[k++] = b[j++];
        }
        return array;
    }

    public static void main(String[] args) {
        int []A = {7,6,5,4,3,2,1};
        A= mergeSort.mergeSort(A, 0, A.length);
        System.out.println(Arrays.toString(A));
    }
}
