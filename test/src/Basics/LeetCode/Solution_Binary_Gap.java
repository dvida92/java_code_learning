package Basics.LeetCode;

/**
 * Binary Gap
 * 1000101 = 64 + 4 + 1 = 69; should return 3
 * 11001001 = 8 + 1 + 64 + 128 = 201; should return 2
 * 1111 = 15; should return 0
 */
public class Solution_Binary_Gap {

    public static int solution(int N) {
            // write your code in Java SE 8
            String s = Integer.toBinaryString(N);
            int counter = 0;
            int maximum = 0;
            boolean flag = false;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1' && !flag ){
                    flag = true;
                    counter = 0;
                }else if(s.charAt(i) == '1' && flag) {
                    if(counter > maximum) {
                        maximum = counter;
                    }
                    counter = 0;

                }else {
                    counter ++;
                }

            }
            return maximum;

        }

    public static void main(String[] args) {
        System.out.println(Solution_Binary_Gap.solution(15));
    }
}
