package CS112.test;


import java.util.Arrays;

/**
 * Created by davidzhou on 3/7/17.
 */
public class test {

    public static void main(String[] args) {
        int [] num1 = {1,2,3,4,5};
        int [] subArray = Arrays.copyOfRange(num1, 1, num1.length);
        System.out.println(Arrays.toString(subArray));
        for (int i :
                subArray) {
            System.out.println(i);

        }
    }


}
