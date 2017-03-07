package CS112.Examples;

import java.util.Arrays;

/**
 * Calculate the matrix product of two 2D arrays
 */
public class CalculateMatrix {

    public static double [][] calculateMatrix(double[][] A, double[][] B) {
        //Determine if two matrices can be multiplied
        if (A[0].length != B.length) return new double[0][0];

        //Create an array to accommodate the result
        double[][] ret = new double[A.length][B[0].length];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j <ret[0].length; j++) {
                ret[i][j] = AB(A, i, B, j);
            }

        }
        return ret;
    }

    public static double AB(double[][] A, double i, double [][]B, double j) {
        double result = 0;
        for (int k = 0; k < A[(int)i].length; k++) {
            result += A[(int)i][k] * B[k][(int)j];
        }
        return result;
    }

    public static void main(String[] args) {
        double [][]A = {{0,1}, {2,3}, {4,5}}; //3 by 2 Matrix
        double [][]B = {{0,1,2},{3,4,5}};     //2 by 3 Matrix
        double [][]C = new double[3][3];

        //A*B
        double [][] result = calculateMatrix(A,B);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        //A*C
        double [][] result2 = calculateMatrix(A,C);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

}
