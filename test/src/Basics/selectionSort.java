package Basics;
import java.util.*;

/**
 * My selection sort
 */
public class selectionSort {

    //Find the minimum element from a[index] to the last element in array a
    public static int findMin(int a[], int index) {
        int currentMinIndex = index;
        for(int i = index + 1; i < a.length; i++) {
            if(a[currentMinIndex] > a[i]) {
                currentMinIndex = i;
            }
        }
        return currentMinIndex;
    }

    //Swap the value of a[num1] and a[num2]
    public static void swap(int [] a, int num1, int num2 ) {
        int tmp = a[num2];
        a[num2] = a[num1];
        a[num1] = tmp;
    }

    //Sort an array in ascending order
    public static  void sort(int [] a) {
        for(int i = 0; i < a.length; i++) {
            int j = findMin(a, i);
            if(j!= i) {
                swap(a, i, j);
            }
        }

    }

    public static void main(String[] args) {
        long sum = 0;
        int size = 800; //size should be sufficiently big
        int a[] = new int[size];

        //Try to analyze running time
        for(int i = 1; i <= 100; i++){
            Random r = new Random();
            for(int j=0; j < size; j++) {
                a[j] = r.nextInt();
            }

            long t1 = System.nanoTime();
            selectionSort.sort(a);
            long t2 = System.nanoTime();

            sum += t2 - t1;
        }



        System.out.println(sum/1e7);

    }
}
