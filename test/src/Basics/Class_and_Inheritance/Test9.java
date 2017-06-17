package Basics.Class_and_Inheritance;

/**
 * Created by davidzhou on 6/6/17.
 * Test Keyword Super
 */

class Father{
    public int value;

    public void f() {
        value = 100;
        System.out.println("Father's value: " + value);
    }
}

class Child extends Father{
    public int value;

    public void f() {
        super.f();
        value = 200;
        System.out.println("Child's value: " + value);
        System.out.println("Father's value: " + super.value);
    }
}

public class Test9 {

    public static void main(String[] args) {
        Child c = new Child();
        c.f();
    }

}
