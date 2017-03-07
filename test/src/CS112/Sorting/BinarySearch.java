package CS112.Sorting;

/**
 * Created by davidzhou on 2/23/17.
 */
public class BinarySearch {

    public static int search(int[]a, int key) {
        int begin = 0;
        int end = a.length - 1;
        while(begin <= end){
            int mid = (begin + end) / 2;
            if(a[mid] == key) return mid;
            if(a[mid] < key) begin = mid + 1;
            if(a[mid] > key) end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1,3,6,7,12};
        int index = BinarySearch.search(a, 5);
        if(index == -1) System.out.println("Cannot find the element!");
        else{
            System.out.println("The index of the element is: " + index);
        }
    }

}
