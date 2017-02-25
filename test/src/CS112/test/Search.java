package CS112.test;

/**
 * Created by davidzhou on 2/25/17.
 */
public class Search {

    //Return index if found the key value in array. Return -1 if failed.
    public static int binary_search(int[] array, int key) {
        int begin = 0;
        int end = array.length;

        while(begin <= end) {
            int mid = (begin + end) / 2;
            if (array[mid] == key) return mid;
            if (array[mid] < key) end = mid - 1;
            if (array[mid] > key) begin = mid + 1;
        }

        return -1;

    }

    public static void main(String[] args) {
        int [] a = {7,6,5,4,3,2,1};
        System.out.println(Search.binary_search(a, 6));
    }
}
