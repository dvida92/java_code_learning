package Basics.LeetCode;

/**
 * 使用递归转换进制:每次递归调用求余数，最终所有的余数从低到高就是进制转换结果。
 * 504. Base 7
 * https://leetcode.com/problems/base-7/#/description
 */
public class Solution_504 {

    public static String convertTo7(int num) {
        if (num < 0)
            return '-' + convertTo7(-num);
        if (num < 7)
            return num + "";
        return convertTo7(num / 7) + num % 7;
    }

    public static void main(String[] args) {
        System.out.println(convertTo7(100));
    }

}
