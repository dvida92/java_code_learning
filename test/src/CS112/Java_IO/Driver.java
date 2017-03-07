package CS112.Java_IO;

/**
 * Created by davidzhou on 3/7/17.
 */
public class Driver {

    public static void main(String[] args) {
        twoD ob = new twoD();
        for (int i = 0; i < 5; i++) {
            System.out.println("Next value is " + ob.getNext());
        }
    }
}
