package Basics.Multithreading;

/**
 * Created by davidzhou on 6/18/17.
 * Without and with Synchronization
 */
public class test6 {

    private static Account account = new Account();

    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(bank);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e) {

        }

        bank.printAccount();
    }

    private static class Bank implements Runnable {

        public void run() {
            for (int i = 0; i < 5; i++) {
                account.depositOneDollar();
                System.out.println("I just deposited one dollar.");
            }
        }

        public void printAccount() {
            System.out.println(account.display());
        }
    }

    private static class Account {
        private static double money = 0;

        public void depositOneDollar() {
            synchronized (this) {
                double newBalance = money + 1;
                try{
                    Thread.sleep(1);
                } catch(InterruptedException e) {

                }

                money = newBalance;
            }

        }

        public String display() {
            return "" + money;
        }
    }
}




