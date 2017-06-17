package CS112.test.testy;


import java.util.Arrays;

/**
 * Created by davidzhou on 6/8/17.
 * Sort: Insertion, selection, merge and quick sort
 */
public class test {


    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minSoFar = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minSoFar] > nums[j]) {
                    minSoFar = j;
                }
            }
            swap(nums, minSoFar, i);
        }
    }

    public static int[] mergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort(int[] nums, int low, int high) {

        if (low == high) {
            return new int[] {nums[low]};
        }

        int mid = (low + high) / 2;
        int[] nums1 = mergeSort(nums, low, mid);
        int[] nums2 = mergeSort(nums, mid + 1, high);
        return merge(nums1, nums2);
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length + nums2.length];
        int p = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                ret[p++] = nums1[p1++];
            } else {
                ret[p++] = nums2[p2++];
            }
        }

        while (p1 < nums1.length) {
            ret[p++] = nums1[p1++];

        }

        while (p2 < nums2.length) {
            ret[p++] = nums2[p2++];

        }

        return ret;
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid + 1, high);

        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = high;
        int lastBig = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, lastBig);
                lastBig++;
            }

        }
        swap(nums, lastBig, pivot);
        return lastBig;
    }



    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums1 = {7, 6, 5, 4, 3, 2, 1};
        int[] nums2 = {7, 6, 5, 4, 3, 2, 1};
        int[] nums3 = {7, 6, 5, 4, 3, 2, 1};
        int[] nums4 = {7, 6, 5, 4, 3, 2, 1};

        selectionSort(nums1);
        insertionSort(nums2);
        quickSort(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(mergeSort(nums4)));

    }

}
