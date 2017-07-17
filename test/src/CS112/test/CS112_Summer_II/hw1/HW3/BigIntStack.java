package CS112.test.CS112_Summer_II.hw1.HW3;


/**
 * Created by davidzhou on 7/17/17.
 */
public class BigIntStack {
    private BigInt[] num;
    private int next;
    private int SIZE = 20;

    BigIntStack() {
        num = new BigInt[SIZE];
        next = 0;
    }

    private void resize() {
        BigInt[] tmp = new BigInt[SIZE * 2];
        for (int i = 0; i < SIZE; i++) {
            tmp[i] = num[i];
        }
        SIZE = SIZE * 2;
        num = tmp;
    }

    public void push(BigInt n) {
        if (size() == SIZE) resize();
        num[next++] = n;
    }

    public BigInt pop() {
        BigInt tmp = num[--next];
        return tmp;
    }

    public int size() {
        return next;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
