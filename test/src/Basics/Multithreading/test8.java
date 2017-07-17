package Basics.Multithreading;

/**
 * Created by davidzhou on 6/18/17.
 * 模拟生产者消费者问题
 * 1.体会面向对象的设计
 * 2.线程互斥锁
 * 3.object的方法wait和notify
 */
public class test8 {

    public static void main(String[] args) {
        BurgerContainer ss = new BurgerContainer();
        Chef chef = new Chef(ss);
        Consumer consumer = new Consumer(ss);
        new Thread(chef).start();
//        new Thread(chef).start();
        new Thread(consumer).start();

    }
}

class Burger {
    int id;
    Burger(int id) {
        this.id = id;
    }

    public String toString() {
        return "Burger{" +
                "id=" + id +
                '}';
    }
}

class BurgerContainer {
    Burger[] container = new Burger[10];
    int index = 0;

    public synchronized void push(Burger burger) {
        while (index == container.length) {
            try {
                this.wait(); //让当前访问该对象的线程等待
            } catch(Exception e) {

            }
        }
        container[index++] = burger;
        this.notifyAll(); //唤醒当前在该对象上等待的进程

    }

    public synchronized Burger pop() {
        while (index == 0) {
            try{
                this.wait();
            } catch(Exception e) {

            }
        }
        this.notifyAll(); //唤醒一个当前在该对象上wait的线程, object's method
        return container[--index];
    }
}

class Chef implements Runnable {

    BurgerContainer ss = null;
    Chef(BurgerContainer ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            Burger burger = new Burger(i);
            ss.push(burger);
            System.out.println(burger + " is ready.");
            try{
                Thread.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    BurgerContainer ss = null;
    Consumer(BurgerContainer ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(ss.pop() + " is consumed.");
            try{
                Thread.sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
