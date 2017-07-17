package CS112.test.CS112_Summer_I.hw2;

/**
 * Created by davidzhou on 7/10/17.
 */
import java.util.Scanner;

public class Histogram1 {

    private static final int MAX_NUMBERS       = 20;             // maximum number of numbers to input
    private static final int NUM_BINS          = 10;             // number of bins in range [0..100]
    private static final int BIN_SIZE          = 100/NUM_BINS;   // size of each bin
    private static final double UPPER_BOUND    = 100.0;          // largest numbers accepted as data
    private static final double LOWER_BOUND    = 0.0;            // smallest numbers accepted as adata

    // print the heading with instructions for the user
    private static void printHeading() {
        System.out.println("\nWelcome to the Histogram Program!");
        System.out.println("This program will print out a histogram of the numbers");
        System.out.println("input by the user; enter up to " + MAX_NUMBERS + " doubles and hit Control-d to end.");
    }

    // Print out the data at the end in the form of a histogram
    private static void printHistogram(int[] histogram) {
        System.out.println("Histogram of Values in Decades from 0 to 100:");
        for(int i = 0; i < NUM_BINS; ++i) {
            if(i == 0)
                System.out.print("[");
            else
                System.out.print("(");
            System.out.print(i * BIN_SIZE + ".." + (i + 1) * BIN_SIZE + "]:" + "\t");
            for(int j = 0; j < histogram[i]; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // check whether a number is in the specified range
    private static boolean validInput(double n) {
        return (n >= LOWER_BOUND && n <= UPPER_BOUND);
    }

    public static void main(String[] args) {


        // Print out welcome message

        printHeading();

        // Define a scanner for user input and read the doubles

        Scanner userInput = new Scanner(System.in);

        // Input doubles from the user using the nextDouble() method
        // When prompted by the "input box" in the Interactions Pane, the user
        // must type in a double and hit return to type Control-d to end input.

        double[] num = new double[MAX_NUMBERS];

        int numNumbers = 0;                      // number of numbers entered

        while(numNumbers < MAX_NUMBERS && userInput.hasNextDouble()) {

            num[numNumbers] = userInput.nextDouble();

            // error checking: if number is not in valid range, make sure input again
            while(!validInput(num[numNumbers])) {
                System.out.println("Input must be a double in range [0..100], try again!");
                num[numNumbers] = userInput.nextDouble();
            }
            ++numNumbers;
        }

        if(numNumbers >= MAX_NUMBERS) {
           System.out.println("Maximum number of inputs (" + MAX_NUMBERS + ") exceeded, proceeding to calculate Histogram...");
        }

        System.out.print("\nYou input " + numNumbers + " numbers: [");
        for(int i = 0; i < numNumbers - 1; ++i)
            System.out.print(num[i] + ", ");
        System.out.println(num[numNumbers - 1] + "]");

        int[] histogram = new int[NUM_BINS];
        for(int i = 0; i < numNumbers; ++i)  {
            for(int j = 0; j < NUM_BINS; ++j) {
                int increment = (j + 1) * BIN_SIZE;
                if(num[i] <= increment) {
                    //        System.out.println(num[i] + " " + incr);
                    ++histogram[j];
                    break;
                }
            }
        }

        printHistogram(histogram);
    }
}