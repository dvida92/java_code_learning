package Basics.LeetCode;

/**
 * Created by davidzhou on 4/22/17.
 * 11. Container with most water
 *
 */
public class Solution_11 {
    /**
     * BF Algorithm: Time Limit Exceeded
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxA = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxA = Math.max((j - i) * Math.min(height[i], height[j]), maxA);
            }
        }
        return maxA;
    }

    /**
     * More efficient Alg
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {


        return 0;
    }

    public static void main(String[] args) {
        int[] height = {1,3,3,1};
        System.out.println(maxArea(height));
    }
}
