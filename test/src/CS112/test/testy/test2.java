package CS112.test.testy;

/**
 * Created by davidzhou on 6/20/17.
 */
public class test2 {
    public static void main(String[] args) {
        Container container = new Container();
        CookMeal cookMeal = new CookMeal(container);
        ConsumeMeal consumeMeal = new ConsumeMeal(container);

        Thread t1 = new Thread(cookMeal);
        Thread t2 = new Thread(consumeMeal);
        t2.start();
        t1.start();
    }
}

class CookMeal implements Runnable {
    private Container c;

    public CookMeal(Container c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            c.put(i);
//            try{
//                Thread.sleep(10);
//            } catch(InterruptedException e) { }
        }
    }
}

class ConsumeMeal implements Runnable {

    private Container c;

    ConsumeMeal(Container c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            c.get();
//            try{
//                Thread.sleep(1);
//            } catch(InterruptedException e) { }
        }
    }
}

class Container {

    class Node{
        int id;
        Node next;

        public Node(int id, Node p) {
            this.id = id;
            next = p;
        }
    }

    private Node head;

    public synchronized void put(int id) {
        if (head == null) {
            head = new Node(id, null);
            System.out.println("Meal $" + id + " is ready.");
            this.notify();
        } else {
            head = new Node(id, head.next);
            System.out.println("Meal #" + id + " is ready.");

            this.notify();
        }

    }

    public synchronized void get() {
        while (head == null) {
            try{
                this.wait();
            } catch(InterruptedException e) { }

        }

        int tmp = head.id;
        System.out.println("Meal #" + tmp + " is consumed.");
        head = head.next;




    }



}