package CS112.Java_IO;

import java.util.Scanner;

/**
 * Created by davidzhou on 3/2/17.
 */
public class scan {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            System.out.println(s.nextLine());

        }


        s.close();
    }
}
