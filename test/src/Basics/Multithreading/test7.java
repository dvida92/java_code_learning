package Basics.Multithreading;

/**
 * Created by davidzhou on 6/18/17.
 * 测试在m1方法锁住时该object的其他部分是否可以被访问;
 * 结论：锁住的仅仅是被synchronized修饰的方法，该object其他部分仍可被访问
 * 改进措施：给m2()加synchronized
 */
public class test7 implements Runnable{

    private int b = 100;

    //当一个线程访问该方法是会尝试锁住当前对象，如果当前对象已被其他线程锁住，则等待。
    public synchronized void m1() throws Exception {
        b = 1000;
        Thread.sleep(5000);  //Sleep时其他线程也不可获取当前对象的lock
        System.out.println("m1: b = " + b);
    }

    //如果没有synchronized修饰m2方法，其他线程可以随时访问m2并且有可能对m1造成影响。
    //这里体现在b的值被修改
    public void m2() throws Exception{
        Thread.sleep(2000);
        b = 2000;
        System.out.println("m2: b = " + b);
    }

    public void run() {
        try{
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test7 tt = new test7();
        Thread thread = new Thread(tt);
        thread.start();
        try{
            tt.m2();
        } catch(Exception e) {

        }

        System.out.println(tt.b);



    }
}
