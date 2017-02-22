package com.company;

import java.util.Random;

/**
 *  This class has a static method that returns an adjacency matrix
 */
public class Adjacency_Matrix {


    public static double [][] generator (int n) {

        double [][] matrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    matrix[i][j] = -1;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Random r = new Random();
                double randomValue = 0 + 1 * r.nextDouble();
                matrix[j][i] = matrix[i][j] = randomValue;
            }

        }
        //random generator

        return matrix;
    }

}
