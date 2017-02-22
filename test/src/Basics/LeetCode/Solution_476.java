package Basics.LeetCode;

/**
 *  476 Number Complement: most used conversion
 */
public class Solution_476 {


    public int findComplement(int num) {
        String s = Integer.toBinaryString(num); //Num to a binary string

        char [] c= s.toCharArray();   //String to a character array


        for (int i = 0; i < c.length; i++) {
            if(c[i] == '0') {
                c[i] = '1';
            }
            else{
                c[i] = '0';
            }
        }


        s = String.valueOf(c);       //character array to a string

        return Integer.parseInt(s, 2);   // Parse a string to an integer
    }


    public static void main(String[] args) {
        Solution_476 ssss = new Solution_476();
        System.out.println(ssss.findComplement(5));
    }
}
