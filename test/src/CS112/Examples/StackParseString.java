package CS112.Examples;

/**
 * Created by davidzhou on 3/6/17.
 */
public class StackParseString {
    private char [] ss;
    private int index;

    StackParseString() {
        ss = new char[100]; //Need constructor to initialize this array, otherwise cannot run
        index = 0;
    }

    public void push(char c) {
        ss[index] = c; //potential index out of bound
        index++;
    }

    public char pop() {
        char c = ss[index - 1]; //potential index out of bound
        index--;
        return c;
    }

    public boolean inputIsBalanced(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                push(c);
            }
            if (c == ')') {
                char tmp = pop();
                if ('(' != tmp) return false;
            }

            if (c == '}') {
                char tmp = pop();
                if ('{' != tmp) return false;
            }
            if (c == ']') {
                char tmp = pop();
                if ('[' != tmp) return false;
            }

        }

        return index == 0; //Use boolean expression to simplify statement
    }


    public static void main(String[] args) {
        StackParseString s = new StackParseString();

        System.out.println(s.inputIsBalanced("(){}"));
        System.out.println(s.inputIsBalanced("(){}{"));

    }
}
