package CS112.test.CS112_Summer_I.Recursion;

/**
 * Created by davidzhou on 6/12/17.
 */
public class NumberOfRoute {

    public static int F(int x, int y) {
        if (x < 0 || y < 0) return 0;
        if ((x == 0 && y == 1)) return 1;
        if (x == 1 && y == 0) return 1;

        return F(x - 1, y) + F(x, y - 1);
    }

    public static void main(String[] args) {
        System.out.println(F(4,4));
    }
}
