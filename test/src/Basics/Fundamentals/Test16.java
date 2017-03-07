package Basics.Fundamentals;

import java.io.*;

/**
 *  Exception: 运行期间出现的错误
 */
public class Test16 {
    public static void main(String[] args) {

        //Example 1
        int[] a = {1, 2, 3};
        try {
            System.out.println(a[4]);   //runtimeexception 数组下标越界
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("haha");
            ae.printStackTrace();
        }


        //Example 2
        FileInputStream in = null;
        try {
            in = new FileInputStream("myfile.txt"); //会抛出filenotfoundexception
            int b;
            b = in.read();   //read方法有可能会抛出ioexception
            while (b != -1) {
                System.out.println((char) b);
                b = in.read();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //Example 3
    //方法m调用方法f，因此方法m要处理方法f抛出的异常;如果m不catch异常，则可以继续throw.
    //main方法也可以throw Exception(所有异常类),java会打印其错误堆栈信息.
    void f() throws IOException{
        FileInputStream in = new FileInputStream("myfile.txt");
        int b;
        b = in.read();

    }

    void m() {
        try{
            f();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
