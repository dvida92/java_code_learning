package Basics.Fundamentals;

/**
 *  When an instance variable/method is the type "static"
 *  Only one static instance for the entire class
 */

class staticTest {
    static int x = 0;
    int y;

    staticTest () {
        y = 1;
    }

    public static int staticMethod () {
        // Cannot access an instance variable that belongs to an instance; Can only access static instance variable
        //return y;

        return x;
    }
}

public class Test11 {
    public static void main(String[] args) { //Why is main static: main is the entrance of a program cuz no class has been created yet.
        System.out.println(staticTest.x); //Use the class name to invoke the variable
        staticTest X = new staticTest();
        System.out.println(X.y);  //System class's out is also static


    }
}
