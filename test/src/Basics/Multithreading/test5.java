package Basics.Multithreading;

/**
 * Created by davidzhou on 6/18/17.
 * yield()
 */
public class test5 {
    public static void main(String[] args) {
        Eagle e1 = new Eagle("Eagle 1");
        Eagle e2 = new Eagle("Eagle 2");

        Thread t1 = new Thread(e1);
        Thread t2 = new Thread(e2);

        t1.start();
        t2.start();


    }
}

class Eagle implements Runnable {
    String name;

    Eagle(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + " is at height " + i);
            if (i % 5 == 0) {
                Thread.yield();
            }
        }
    }
}
