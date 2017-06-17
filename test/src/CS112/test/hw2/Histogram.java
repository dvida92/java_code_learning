package CS112.test.hw2;

import java.util.Scanner;

/**
 * Created by davidzhou on 5/30/17.
 */
public class Histogram {


    public static final int MAX_NUMBERS = 20;             // maximum number of numbers to input
    public static final int NUM_BINS = 10;              // number of bins in range [0..100]
    public static final int BIN_SIZE  =  100 / NUM_BINS;
    private static final double UPPER_BOUND = 100.0;          // largest numbers accepted as data
    private static final double LOWER_BOUND = 0.0;

    private static void printHeading() {
        System.out.println("\nWelcome to the Histogram Program!");
        System.out.println("This program will print out a histogram of the numbers");
        System.out.println("input by the user; enter up to " + MAX_NUMBERS + " doubles and hit Control-d to end.");
    }

    private static void printHistogram(int[] histogram) {
        System.out.println("Histogram of Values in Decades from 0 to 100:");
        for(int i = 0; i < NUM_BINS; ++i) {
            if(i == 0)
                System.out.print("[");
            else
                System.out.print("(");
            System.out.print(i*BIN_SIZE + ".." + (i*BIN_SIZE+BIN_SIZE) + "]:" + "\t");
            for(int j = 0; j < histogram[i]; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static boolean validInput(double n) {
        return (n >= LOWER_BOUND && n <= UPPER_BOUND);
    }

    public static void main(String[] args) {
        double[] number = new double[20];

        int[] histogram = new int[NUM_BINS];

        System.out.println("Please input numbers from 0 to 100 inclusive(at most 20 numbers): ");
        Scanner userInput = new Scanner(System.in);
        int counter = 0;

        while (counter < MAX_NUMBERS && userInput.hasNextDouble()){
            double tmp = userInput.nextDouble();
            if (tmp < 0 || tmp > 100) {
                System.out.println("Please enter a valid number!");
                continue;
            }
            number[counter] = tmp;
            counter++;
        }



    }
}
