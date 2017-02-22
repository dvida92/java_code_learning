package Basics;

/**
 *  命令行参数 String [] args
 */
public class Test17 {
    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("请输入格式 \"n1\" \"op\" \"n2\" ");
            System.exit(-1);
        }

        double d1 = Double.parseDouble(args[0]);
        double d2 = Double.parseDouble(args[2]);
        double d = 0;
        if(args[1].equals("+")) d = d1 + d2;
        else if(args[1].equals("-")) d = d1 - d2;
        else if(args[1].equals("*")) d = d1 * d2;
        else if(args[1].equals("/")) d = d1 / d2;
        else{
            System.out.println("Error operator!");
            System.exit(-1);
        }
        System.out.println(d);
    }

}
