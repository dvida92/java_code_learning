package Basics.LeetCode;

/**
 * Created by davidzhou on 3/18/17.
 * 122 Best Time to Buy sand Sell Stock II
 */
public class Solution_122 {

    /**
     * 任何时刻手里只能持有一张股票，买卖次数不限。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int share = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] >= prices[i]) {
                if (share == 0) {
                    profit += prices[i + 1] - prices[i];
                    share++;
                } else{
                    profit += prices[i + 1] - prices[i];
                }
            } else if (prices[i + 1] < prices[i]) {
                share--;
            }

        }
        return profit;
    }

    public static void main(String[] args) {

    }
}
