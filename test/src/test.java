/**
 * Output prime numbers within 101-200
*/
public class test {


    public static int problem1(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(mid * mid == n) {
                return mid;
            }

            if(mid * mid > n) {
                high = mid - 1;
            }

            if(mid * mid < n) {
                low = mid + 1;
            }

        }

        return high;
    }

    public static void main(String[] args) {
        System.out.println(problem1(2));
    }
}

