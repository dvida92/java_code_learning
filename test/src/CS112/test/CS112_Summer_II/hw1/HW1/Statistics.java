package CS112.test.CS112_Summer_II.hw1.HW1;

/**
 * Created by davidzhou on 7/6/17.
 */

import java.util.Scanner;

public class Statistics {

    public static void main(String[] args) {

        // Print out welcome message

        System.out.println("\nThis is the template for problem B.2");


        // Define a scanner for user input

        Scanner userInput = new Scanner(System.in);

        // Input integers from the user using the nextInt() method
        // When prompted by the "input box" in the Interactions Pane, the user
        // must type in an integer and hit return.

        System.out.println("\nType in the first number and then hit return:");
        int numOne = userInput.nextInt();

        System.out.println("\nYour input was " + numOne);

        System.out.println("\nType in the first number and then hit return:");
        int numTwo = userInput.nextInt();

        System.out.println("\nYour input was " + numTwo);

        System.out.println("\nType in the first number and then hit return:");
        int numThree = userInput.nextInt();

        System.out.println("\nYour input was " + numThree);



        int sum = numOne + numTwo + numThree;
        System.out.println("Sum: " + sum);

        int max = Math.max(numThree, Math.max(numOne, numTwo));
        System.out.println("Max: " + max);

        int min = Math.min(numOne, Math.min(numTwo, numThree));
        int range = max - min;
        System.out.println("Range: " + range);

        double average = sum / 3.0;
        System.out.printf("The mean is %.4f\n",average);


        double sd = Math.sqrt((Math.pow(average - numOne,2) +  Math.pow(average - numTwo,2) +
                Math.pow(average - numThree, 2)) / 3);
        System.out.printf("Standard Deviation: %.4f\n" ,sd);

        int median = numOne + numThree + numTwo - max - min;
        System.out.println("Three numbers: " + min + " " + median + " " + max + " ");

        userInput.close();


    }

}