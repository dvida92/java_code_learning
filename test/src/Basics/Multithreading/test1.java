package Basics.Multithreading;

/**
 * Created by davidzhou on 6/17/17.
 */
public class test1 {
    public static void main(String[] args) {

        Runnable task1 = new PrintChar("A", 1000);
        PrintNumber task2 = new PrintNumber(500);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();


    }

}

class PrintChar implements Runnable {

    String word;
    int time;

    PrintChar(String word, int time) {
        this.word = word;
        this.time = time;
    }

    public void run() {
        for (int i = 0; i < time; i++) {
            System.out.println(word);
        }
    }

    public void haha() {

    }
}

class PrintNumber implements Runnable {

    int number;

    PrintNumber(int number) {
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println(i);
        }
    }

    public void haha() {

    }
}
