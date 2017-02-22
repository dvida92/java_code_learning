package com.company;

import java.util.Arrays;

/**
 * Created by davidzhou on 2/19/17.
 */
public class MST_Driver {


    public static void main(String[] args) {


        //double [][] mm = MST.sort(matrix);

        //for (int i = 0; i < matrix.length; i++) {
          //  System.out.println(Arrays.toString(mm[i]));

        //}

        double total = 0;
        for (int j = 0; j < 5; j++) {
            double [][] matrix = Adjacency_Matrix.generator(16);

            total += MST.run_MST(matrix);
        }
        System.out.println(total/5);




    }
}
