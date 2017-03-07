package Basics.Fundamentals;


/**
 * Static member variable
 */

class Student {
    private String name;
    private int age;

    //Every student share the same school because of keyword "static". School belongs to the entire class.
    private static String school = "Boston University"; //Static variable and literal are stored in data seg.
    public static String department = "Computer Science";

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public void setName(String s1) {
        name = s1;
    }

}


public class Test6 {
    public static void main(String[] args) {
        System.out.println(Student.department); //class.static variable  直接使用static成员变量

        Student s1 = new Student();
        Student s2 = new Student();

        s2.setName("David"); //Static variable and literal("David") are stored in data seg(数据区).
        System.out.println(s1.getName());
        System.out.println(s2.getSchool());
        System.out.println(s2.getName());
    }
}
