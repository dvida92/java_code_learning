package CS112.test;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by davidzhou on 4/10/17.
 */
public class test {

    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = Arrays.copyOfRange(a, 0, 1);
        System.out.println(Arrays.toString(b));
        System.out.println(b.length);

    }




}


