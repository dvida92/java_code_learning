package Basics.LeetCode;

/**
 * Created by davidzhou on 5/28/17.
 */
public class Solution_67 {
    public String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            sum += a.charAt(i);
            sum += b.charAt(j);

        }
        return null;
    }

    public static void main (String[] argv)
    {
        int[] A = { 1, 2, 3, 4, 5, 6 };
        for(int i = 0; i < A.length; ++i) {
            if( A[i] % 2 == 0 )
                continue;
            else if( A[i] > 4 )
                break;
            else
                A[i] *= 2;
        }
        for(int i = 0; i < A.length; ++i)
            System.out.println(A[i]);
    }


}
