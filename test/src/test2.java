/**
 *  Problem 2
 */
public class test2 {

    public static int problem2(int[] a) {
        int low = 0;
        int high = a.length - 1;

        if(a.length <= 2) {
            System.out.println("The input array only has" + " " + a.length + " elements!");
            System.out.println("Please try again.");
            return -1;
        }

        while(low <= high) {
            int mid = (low + high) / 2;

            if(a[mid - 1] < a[mid] && a[mid + 1] < a[mid]) {
                return a[mid];

            }

            if(a[mid - 1] < a[mid] && a[mid] < a[mid + 1]) {
                low = mid + 1;
            }

            if(a[mid - 1] > a[mid] && a[mid] > a[mid + 1]) {
                high = mid - 1;
            }
        }
        return a[high];
    }


    public static void main(String[] args) {
        int [] a = {0};
        System.out.println(problem2(a));
    }
}
