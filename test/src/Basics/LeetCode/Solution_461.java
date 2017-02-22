package Basics.LeetCode;

/**
 *  461 Hamming Distance
 */

    public class Solution_461 {
        public static int hammingDistance(int x, int y) {
            String s1 = Integer.toBinaryString(x);
            String s2 = Integer.toBinaryString(y);
            String s3 = s00(s1);
            String s4 = s00(s2);

            int sum = 0;
            for(int i = 0; i < 31; i++)
                if(s3.charAt(i) != s4.charAt(i)) sum++;

            return sum;

        }

        //Add "0" to the string if its length is not 31
        public static String s00(String s) {
            if(s.length() < 31) {
                int num = s.length();
                for(int i = 1; i <= 31 - num; i++){
                    s = "0" + s;

                }
            }
            return s;
        }

    public static void main(String[] args) {

        System.out.println(Solution_461.hammingDistance(1,5));
    }
}
