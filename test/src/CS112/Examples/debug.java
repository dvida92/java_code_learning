package CS112.Examples;

/**
 *  Three way to debug:
 *  1.Step into
 *  2.Step over
 *  3.Step out of(return)
 */
public class debug {

    public  int x = 0;
    public  void f() {
        x++;
    }

    public  void p() {
        f();
        x++;
    }

    public static void main(String[] args) {
        debug d = new debug();
        d.f();
        d.p();

        System.out.println(d.x);
    }
}
