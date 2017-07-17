package Basics.Multithreading;

/**
 * Created by davidzhou on 6/18/17.
 * The difference between thread.start() and task.run()
 */
public class test3 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Thread thread = new Thread(a);
//        thread.start();

        //First call run(). After finish run, go back to main and continue the rest.
        //Run() and main() is not executing at the same time.
        a.run();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main is running...");
        }
    }
}

class Animal implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Animal is running...");
        }
    }
}
