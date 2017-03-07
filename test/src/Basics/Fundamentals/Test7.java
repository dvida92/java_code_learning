package Basics.Fundamentals;

/**
 * Created by davidzhou on 1/29/17.
 */
public class Test7 {
    public static void main(String[] args) {
        TT tt1 = new TT();
        tt1.m();
    }
}


class T {
    private int i = 0;
    int j = 0; //Default
    protected int k = 0;
    public int m = 0;
}


class TT {
    public void m() {
        T t = new T();
        //System.out.println(t.i); private class member variable
        System.out.println(t.j); //Default class member variable
    }
}