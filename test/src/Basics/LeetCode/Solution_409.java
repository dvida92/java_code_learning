package Basics.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidzhou on 3/19/17.
 * 409.Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/#/description
 */
public class Solution_409 {

    /**
     * 我的算法：所有出现偶数次的元素（的次数）+ 一个出现频率最高的奇数次（的次数）= 题解 WRONG!
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {

        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        List<Integer> occurrence = new LinkedList<>();

        //Test
        System.out.println(Arrays.toString(sorted));

        if (sorted.length == 1) return 1;

        int counter = 1;
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i + 1]) {
                counter++;
                if (i == sorted.length - 2) {
                    occurrence.add(counter);
                }
            } else {
                occurrence.add(counter);
                counter = 1;
                if (i == sorted.length - 2) {
                    occurrence.add(counter);
                }
            }
        }

        int[] occurrenceArray = new int[occurrence.size()];
        int i = 0;
        for (Integer n :
                occurrence) {
            occurrenceArray[i++] = n;
        }

        int totalLength = 0;
        int maxOddOccur = 0;
        for (int j = 0; j < occurrenceArray.length; j++) {
            if (occurrenceArray[j] % 2 == 0) {
                totalLength += occurrenceArray[j];
            } else {
                if (occurrenceArray[j] > maxOddOccur) {
                    maxOddOccur = occurrenceArray[j];
                }
            }

        }

        return totalLength + maxOddOccur;
    }


    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));
    }
}
