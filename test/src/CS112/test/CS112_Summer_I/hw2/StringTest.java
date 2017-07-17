package CS112.test.CS112_Summer_I.hw2;

/**
 * Created by davidzhou on 5/29/17.
 */

import java.util.Scanner;

public class StringTest {

    public static void main(String[] args) {

        // Print out welcome message

        System.out.println("\nWelcome to the String Test Program!");
        System.out.println("Demonstrate various features of the String Library");

        // Define a scanner for user input

        Scanner userInput = new Scanner(System.in);

        char[] charsToRemove = { '.', ',', ';', ':', '?', '/', '\'', '\"', '!', '-', '~', '(', ')', ' ' };


        System.out.println("\nType in a sentence or Control-d to end:");
        while(userInput.hasNextLine()) {
            String line = userInput.nextLine();
            for (int i = 0; i < charsToRemove.length; i++) {
                line = line.replace(Character.toString(charsToRemove[i]), "");
            }

            line = line.toLowerCase();
            boolean flag = false;
            for (int i = 0; i < line.length() - 1 - i ; i++) {
                if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
                    System.out.println("Not a palindrome!");
                    flag = true;
                    break;
                }
                else continue;
            }
            if (!flag) {
                System.out.println("Palindrome!");
            }

        }


    }

}