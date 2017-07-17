package CS112.test.CS112_Summer_I.hw2;

/**
 * Created by davidzhou on 5/30/17.
 */
public class ScopeTest {

    public static int A = 2;

    // location 1



    public static void B( int C ) {
        // location 2
    }

    public static void main (String[] argv)
    {
        // location 3
        int D = 2;
        // location 4
        for( int E = 0; E < 10; ++E ) {
            // location 5
            if( D < A ) {
                int F = 1;
                // location 6
            }
            // location 7
        }
        // location 8
    }

// location 9

    public static int G = 2;

}
/*   Solution:
 * A: 1 - 9 (all)
 * B: 1 - 9 (all)
 * C: 2
 * D: 4 - 8
 * E: 5 - 7
 * F: 6
 * G: 1 - 9 (all)
 */

