package CS112.test.CS112_Summer_II.hw1.HW3;

/**
 * Created by davidzhou on 7/17/17.
 */
public class StringStack {
    private String[] S;
    private int next;
    private int SIZE = 2;

    StringStack() {
        S = new String[SIZE];
        next = 0;
    }

    private void resize() {
        String[] tmp = new String[SIZE * 2];
        for (int i = 0; i < SIZE; i++) {
            tmp[i] = S[i];
        }
        S = tmp;
        SIZE = SIZE * 2;
    }

    public void push(String s) {
        if (next == SIZE) resize();
        S[next++] = s;
    }

    public String pop() {
        String s = S[--next];
        return s;
    }

    public int size() {
        return next;
    }

    public boolean isEmpty() {
        return size() == 0;
    }



}
