package Basics.Fundamentals;

import java.util.Arrays;

/**
 * Use built-in function in class Arrays: sort() and binarySearch(array, key)
 */
public class BuiltInBinarySearch {
    public static void main(String[] args) {
        int [] nums = {3, 2, 4, 1, 5};
        Arrays.sort(nums);
        int index = Arrays.binarySearch(nums, 3);
        int index2 = Arrays.binarySearch(nums, 100);
        System.out.println("The index of key 3: " + index);
        System.out.println("The index of key 100: " + index2); //
    }
}
