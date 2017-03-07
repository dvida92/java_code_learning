package CS112.Examples;

import java.util.Scanner;

/**
 * Determine the number of parenthesis
 */
public class CharStack {

    static int MAX_SIZE = 1000; //Uppercase for constant value
    private char [] s;
    private int size;


    CharStack() {
        s = new char[MAX_SIZE];
        size = 0;
    }

    public void push(char c) {
        s[size++] = c;

    }

    public char pop () {

       return s[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }  //返回值可以直接用表达式，否则冗余。

    public static boolean match(char s, char c) {

        return false;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharStack parenStack = new CharStack();

        while(scanner.hasNext()) {
            String s = scanner.nextLine();


            for (int i = 0; i < s.length() ; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c ==  '{')  {
                    parenStack.push(c);
                }

                try {
                    if (c == ')' || c == ']' || c == '}' && !match(parenStack.pop(), c)) {
                        System.out.println("None Matching~");
                    }

                } catch (RuntimeException e) {
                    System.out.println("Too many closing parens.");
                }
            }
        }

        scanner.close();
    }
}
