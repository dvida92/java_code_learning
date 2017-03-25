package Basics.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by davidzhou on 3/21/17.
 */
public class Solution_121 {

    /**
     * Brute Force Algorithm: Time Limit Exceeded
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        List<Integer> list = new ArrayList<>();

        if (prices.length == 0 || prices.length == 1) return 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                list.add(prices[j] - prices[i]);
            }
        }

        int[] ret = new int[list.size()];
        int index = 0;
        for (Integer n :
                list) {
            ret[index++] = n;
        }
        Arrays.sort(ret);

        if (ret[ret.length - 1] > 0) return ret[ret.length - 1];
        else return 0;
    }


    /**
     * 正确算法：注意如何在for循环中设置变量
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int soFarMinElement = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < soFarMinElement) soFarMinElement = prices[i];
            else {
                maxProfit = Math.max(prices[i] - soFarMinElement, maxProfit);
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] nums = {7,2,4,6,1};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit2(nums));
    }
}
