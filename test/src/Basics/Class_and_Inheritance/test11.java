package Basics.Class_and_Inheritance;

/**
 * Created by davidzhou on 6/13/17.
 * Object 转型
 */

class Animal {
    String name;
    public void sound() {
        System.out.println("Animal sound");
    }


}


class Cat extends Animal{
    String catProperty;

    public void sound() {
        System.out.println("Cat sound");
    }

    public void test() {

    }
}


public class test11 {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        System.out.println(a1.name);

        Cat c1 = new Cat();
        System.out.println(c1.name);
        System.out.println(c1.catProperty);

        Animal a2 = new Cat();
        Cat c2 = (Cat) a2;  //转型

        System.out.println(a2 instanceof Animal);
        System.out.println(a2 instanceof Cat);

        a2.sound();



    }


}
