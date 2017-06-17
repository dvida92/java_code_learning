package Basics.Polymorphism;

/**
 * Created by davidzhou on 6/13/17.
 *
 * Polymorphism: Dynamic Binding
 *
 */

class Animal{

    private String name;

    Animal(String name) {
        this.name = name;
    }
    public void sound(){
        System.out.println("Animal making sound!");
    }

}

class Cat extends Animal{
    private String color;

    Cat(String name, String color) {
        super(name);
        this.color = color;
    }

    public void sound() {
        System.out.println("Cat meowing!");
    }
}

class Dog extends Animal{
    private int size;

    Dog(String name, int size) {
        super(name);
        this.size = size;
    }

    public void sound() {
        System.out.println("Dog barking!");
    }
}

class Person{
    private String name;
    private Animal pet;

    Person(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void petSound() {
        pet.sound();
    }
}

public class Example_1 {



    public static void main(String[] args) {

        Cat c1 = new Cat("cat1", "blue");
        Dog d1 = new Dog("dog1", 1);
        Person p1 = new Person("Mary", c1);
        Person p2 = new Person("Jack", d1);

        p1.petSound();
        p2.petSound();
    }
}
