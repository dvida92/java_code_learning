package CS112;

/**
 * Bubble Sort: https://en.wikipedia.org/wiki/Bubble_sort
 *  Relatively inefficient!
 */
public class bubbleSort {

    //Version 1 loops n-1 times
    public static void sort(int [] a) {
        for(int pass = 0; pass < a.length - 1; pass++) {
            for(int i = 0; i < a.length - 1 - pass; i ++) {
                if(a[i] > a[i + 1]) {
                    int tmp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }


    //Version 2 with an end condition
    public static void sort2(int [] a) {

        /** The usage of FLAG */
        boolean timeToQuit = false;

        for(int pass = 0; !timeToQuit && pass < a.length - 1; pass++) {
            for(int i = 0; i < a.length - 1 - pass; i ++) {
                if(a[i] > a[i + 1]) {
                    int tmp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = tmp;
                    timeToQuit = false;
                }
            }
        }
    }



    public static void main(String[] args) {
        int a[] = {3, 2, 1};
        bubbleSort.sort2(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
