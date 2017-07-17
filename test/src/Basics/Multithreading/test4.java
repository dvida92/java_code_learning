package Basics.Multithreading;

import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * Created by davidzhou on 6/18/17.
 * sleep() and interrupt()
 */
public class test4 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Thread thread = new Thread(cat);
        thread.start();

        try{
            sleep(10000); //main thread sleep
        } catch(InterruptedException e) { }

//        thread.interrupt();
        cat.flag = false; // How to stop thread
    }
}

class Cat implements Runnable {

    boolean flag = true;
    public void run() {  //When run terminates, the thread terminates
        while (flag) {
            System.out.println("===" + new Date() + "===");
            try {
                sleep(1000);
            } catch(InterruptedException e) {
                return;
            }
        }
    }
}
