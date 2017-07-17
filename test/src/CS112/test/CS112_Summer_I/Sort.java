package CS112.test.CS112_Summer_I;

import java.util.Arrays;

/**
 * Created by davidzhou on 6/5/17.
 */
public class Sort {

    public static void selectionSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int minSoFar = i;
            for (int j = i; j < num.length; j++) {
                if (num[j] < num[minSoFar]) minSoFar = j;
            }
            swap(num, minSoFar, i);
        }
    }

    public static void insertionSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (num[j] < num[j - 1]) {
                    swap(num, j, j - 1);
                }
            }
        }
    }

    public static void quickSort(int[] num) {
        quickSort(num, 0, num.length - 1);
    }

    private static void quickSort(int[] num, int low, int high) {
        if (low < high) {
            int index = partition(num, low, high);
            quickSort(num, low, index - 1);
            quickSort(num, index + 1, high);
        }
    }

    private static int partition(int[] num, int low, int high) {
        int pivot = num[low];
        int last = low + 1;
        for (int i = low + 1; i <= high; i++) {
            if (num[i] < pivot) {
                swap(num, i, last);
                last++;
            }
        }
        swap(num, last - 1, low);
        return last - 1;
    }

    public static int[] mergeSort(int[] num) {
        return mergeSort(num, 0, num.length - 1);
    }

    private static int[] mergeSort(int[] num, int low, int high) {
        //Base Case
        if (low == high) {
            int[] ret = {num[low]};
            return ret;
        }


        int mid = (low + high) / 2;
        int[] num1 = mergeSort(num, low, mid);
        int[] num2 = mergeSort(num, mid + 1, high);
        return merge(num1, num2);

    }

    private static int[] merge(int[] num1, int[] num2) {
        int[] ret = new int[num1.length + num2.length];
        int p = 0, p1 = 0, p2 = 0;
        while (p1 < num1.length && p2 < num2.length) {
            if (num1[p1] <= num2[p2]) {
                ret[p++] = num1[p1++];
            } else{
                ret[p++] = num2[p2++];
            }
        }

        while (p1 < num1.length) {
            ret[p++] = num1[p1++];
        }

        while (p2 < num2.length) {
            ret[p++] = num2[p2++];
        }

        return ret;
    }


    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }


    public static void main(String[] args) {
        int[] num1 = {7,6,5,4,3,2,1};
        int[] num2 = {7,6,5,4,3,2,1};
        int[] num3 = {7,6,5,4,3,2,1};
        int[] num4 = {7,6,5,4,3,2,1};

        selectionSort(num1);
        System.out.println(Arrays.toString(num1));

        insertionSort(num2);
        System.out.println(Arrays.toString(num2));

        quickSort(num3);
        System.out.println(Arrays.toString(num3));


        System.out.println(Arrays.toString(mergeSort(num4)));
    }
}
