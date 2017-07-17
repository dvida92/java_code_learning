package CS112.test.CS112_Summer_I.hw2;



/**
 * Created by davidzhou on 5/29/17.
 */

import java.util.Arrays;
import java.util.Scanner;

public class StringTest2 {

    public static void main(String[] args) {

        // Print out welcome message

        System.out.println("\nWelcome to the String Test Program!");
        System.out.println("Demonstrate various features of the String Library");

        // Define a scanner for user input

        Scanner userInput = new Scanner(System.in);

        char[] charsToRemove = { '.', ',', ';', ':', '?', '/', '\'', '\"', '!', '-', '~', '(', ')'};


        System.out.println("\nType in a sentence or Control-d to end:");
        while(userInput.hasNextLine()) {
            String line = userInput.nextLine();
            for (int i = 0; i < charsToRemove.length; i++) {
                line = line.replace(Character.toString(charsToRemove[i]), "");
            }

            line = line.toLowerCase();
            String[] word = line.split("\\s+");


            boolean flag = true;
            for (int i = 0; i < word.length - 1 - i ; i++) {
                if (word[i].equals(word[word.length - 1 - i])) {
                    continue;
                }
                else {
                    flag = false;
                    break;
                }
            }

            System.out.println(Arrays.toString(word));

            if (flag) {
                System.out.println("Word Palindrome!");
            } else {
                System.out.println("Not a word palindrome!");
            }

        }


    }

}