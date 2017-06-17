package Basics.Class_and_Inheritance;

/**
 * Created by davidzhou on 6/13/17.
 * Overriding equals()
 */
public class test10 {
    private String name;
    private int age;

    public test10(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //在这里重写object的equals方法
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof test10) {  //注意instanceof关键字
            test10 t1 = (test10) obj; //先把obj的类型确定
            if (name == t1.name && age == t1.age) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        test10 t1 = new test10("haha", 1);
        test10 t2 = new test10("lol", 2);
        test10 t3 = new test10("lol", 2);


        System.out.println(t1.equals(t2));
        System.out.println(t2.equals(t3));
    }
}
