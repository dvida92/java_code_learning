package Basics.LeetCode;

import java.util.LinkedList;


/**
 *  LeetCode : 500 - Keyboard Row
 */
public class Solution_500 {

    public static void main(String[] args) {
        String [] s1 = {"Hello","Alaska","dad","Peace"};

        String [] s2 = Solution_500.findWords(s1);

        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
    }


    public static String[] findWords(String[] words) {
        char [] row1 = {'q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'};
        char [] row2 = {'a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'};
        char [] row3 = {'z','x','c','v','b','n','m', 'Z','X','C','V','B','N','M'};

        LinkedList <String> ss = new LinkedList<String> ();

        Solution_500.findCharacter(row1, words, ss);
        Solution_500.findCharacter(row2, words, ss);
        Solution_500.findCharacter(row3, words, ss);

        String [] ss1 =  ss.toArray(new String[0]);

        return ss1;

    }



    public static void findCharacter(char []row, String [] words, LinkedList <String> ss) {
        for(int i = 0; i < words.length; i++) { //for every word in the input string array "words[]"
            int sum = 0;
            for(int j = 0; j < words[i].length(); j++) { //for every letter in a word
                for(int k = 0; k < row.length; k ++) {  //for every letter in the char array "row[]"
                    if(words[i].charAt(j) == row[k]) sum ++;
                }
            }
            if (sum == words[i].length()) ss.add(words[i]);

        }
    }
}