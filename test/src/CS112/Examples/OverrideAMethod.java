package CS112.Examples;

/**
 * Created by davidzhou on 4/4/17.
 */
public class OverrideAMethod {

    public int data;

    //Overriding a method:class "OverrideAMethod" implements Object
    public String toString() {
        return "hello world";
    }

    public static void main(String[] args) {
        OverrideAMethod obj = new OverrideAMethod();
        System.out.println(obj);
    }


}
