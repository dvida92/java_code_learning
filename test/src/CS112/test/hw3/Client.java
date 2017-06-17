package CS112.test.hw3;

/**
 * Created by davidzhou on 6/2/17.
 */
public class Client {


    public static void main(String[] args) {

        System.out.println("Testing the BigInt Library using client program....\n" +
                "\n" +
                "The current population of the earth is:");

        String s = "7452483716";
        int[] num = BigInt.stringToBigInt(s);
        System.out.println(BigInt.bigIntToString(num));

        System.out.println();
        System.out.println("If we double every 63 years, then in 2205 (after 3 doublings),\n" +
                "the population of the earth will be:");
        int[] result = num;
        for (int i = 0; i < 7; i++) {
            result = BigInt.add(result, num);
        }
        System.out.println(BigInt.bigIntToString(result));

        System.out.println();
        System.out.println();
        System.out.println("Testing the Set ADT using client program....\n" +
                "\n" +
                "\n" +
                "Using the Sieve of Eratosthenes to find prime numbers:\n" +
                "\n" +
                "\n" +
                "First we create a set consisting of the numbers 2..1000, then\n" +
                "for all numbers n = 2,...,500, for k > 1, remove\n" +
                "any multiples k*n <= 1000.\n" +
                "\n" +
                "\n" +
                "Here are the prime numbers between 2 and 1000:");

        Set set = new Set();
        for (int i = 2; i <= 1000; i++) {
            set.insert(i);
        }

        for (int i = 2; i <= 500; i++) {
            for (int j = 2; j * i <= 1000; j++) {
                set.delete(j * i);
            }
        }



        System.out.println();
        System.out.println(set);
    }
}
