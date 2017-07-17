package Basics.Multithreading;

/**
 * Created by davidzhou on 6/18/17.
 * thread's join() method
 */
public class test2 {

    public static void main(String[] args) {
        Person p1 = new Person();
        Thread t1 = new Thread(p1);
        t1.start();
    }
}

class Person implements Runnable {

    public void run() {
        Thread t2 = new Thread(new Dog());
        t2.start();

        try {
            for (int i = 0; i < 3000; i++) {
                System.out.println("Person is running...");
                if (i == 500) {
                    t2.join();  //Join() throws InterruptedException
                }               // thread t1(Person) wait for t2(Dog) to finish and then continue
            }
        } catch(InterruptedException e) {

        }

    }
}

class Dog implements Runnable {

    public void run() {
        for (int i = 0; i < 1200; i++) {
            System.out.println("Dog is running...");
        }
    }
}

