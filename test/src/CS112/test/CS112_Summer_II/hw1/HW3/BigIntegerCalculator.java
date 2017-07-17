package CS112.test.CS112_Summer_II.hw1.HW3;

/**
 * Created by davidzhou on 7/17/17.
 */


import java.util.*;

public class BigIntegerCalculator {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Your message here!");

        while(sc.hasNext()) {
            String s = sc.nextLine();
            s = s.replaceAll("\\(",  " \\( ");
            s = s.replaceAll("\\)",  " \\) ");
            s = s.replaceAll("\\*",  " \\* ");
            s = s.replaceAll("\\+",  " \\+ ");
            s = s.trim();
            String[] exp = s.split("\\s+");
            if(exp[0].equals("-1")) {
                break;
            }

            // Your code here

            StringStack stringStack = new StringStack();
            BigIntStack bigIntStack = new BigIntStack();

            for (int i = 0; i < exp.length; i++) {
                if (exp[i].equals("(")) continue;
                else if (exp[i].equals("+") || exp[i].equals("*")) stringStack.push(exp[i]);
                else if (exp[i].equals(")")) {
                    BigInt n1 = bigIntStack.pop();
                    BigInt n2 = bigIntStack.pop();
                    String operator = stringStack.pop();
                    if (operator.equals("+")) {
                        bigIntStack.push(n1.add(n2));
                    } else if (operator.equals("*")) {
                        bigIntStack.push(n1.mult(n2));
                    }
                } else {
                    bigIntStack.push(new BigInt(exp[i]));
                }
            }

            System.out.println("The result is " + bigIntStack.pop());

        }
        System.out.println("bye!");
        sc.close();
    }
}