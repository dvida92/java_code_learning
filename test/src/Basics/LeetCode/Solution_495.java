package Basics.LeetCode;

/**
 * Created by davidzhou on 4/14/17.
 * 495.Teemo Attacking
 * https://leetcode.com/problems/teemo-attacking/#/description
 */
public class Solution_495 {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalTime = 0;

        //Corner Cases:
        if (timeSeries.length == 0) return 0;
        if (timeSeries.length == 1) return duration;
        if (timeSeries.length == 2) {
            if (timeSeries[1] - timeSeries[0] < duration) {
                return timeSeries[1] - timeSeries[0] + duration;
            }
            return duration * 2;
        }


        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] < duration) {
                totalTime += timeSeries[i + 1] - timeSeries[i];
            } else{
                totalTime += duration;
            }

        }
        totalTime += duration;
        return totalTime;
    }
}
