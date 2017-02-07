package CS112;

/**
 * Created by davidzhou on 2/7/17.
 */
public class bubbleSort {

    //Version 1
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


    //Version 2 with a flag
    public static void sort2(int [] a) {

        /** The usage of FLAG */
        boolean timeToQuit = false;

        for(int pass = 0; !timeToQuit; pass++) {
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

    }
}
