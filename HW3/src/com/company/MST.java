package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by davidzhou on 2/19/17.
 */
public class MST {


    // Retrieve half of the elements in the adjacency matrix into an array and sort them
    public static double [][] sort(double [][] array) {
        int n = array.length;

        double[][] a = new double[n * (n - 1) / 2][3];

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                a[k][0] = array[j][i];
                a[k][1] = j;

                a[k][2] = i;
                k++;
            }
        }

       Arrays.sort(a, (b,c) -> Double.compare(b[0],c[0]));
        return a;

    }



    //union-find
    public static double union_find(double node, double [] component){
        double set = component [(int) node];
        return set;
    }


    //union
    public static void union(double set1, double set2, double [] component){
        for (int i = 0; i < component.length; i++) {

            if (component[i] == set1) {
                component[i] = set2;
            }

        }

    }

    public static double run_MST (double[][] graph){

        double [] component = new double [graph.length];
        for (int i = 0; i < component.length; i++) {
            component[i] = i;

        }
        double weight_sum = 0;
        //run sort
        double [][] sortedarray = sort(graph);
        //run union-find on first 2 nodes
        for (int i = 0; i < sortedarray.length; i++) {
            if (union_find(sortedarray[i][1], component) != union_find(sortedarray[i][2], component)){
                union(sortedarray[i][1], sortedarray[i][2], component);
                weight_sum += sortedarray[i][0];
            }

        }
        return weight_sum;

    }
}
