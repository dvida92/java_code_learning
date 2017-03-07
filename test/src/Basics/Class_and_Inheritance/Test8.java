package Basics.Class_and_Inheritance;

/**
 *  Inheritance
 */

class Person {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getInfo() {
        return "Name: " + name + "\n" + "Age: " + age;
    }
}

//Subclass "Stu"(子类) inherits superclass "Person"（基类）
class Stu extends Person {
    private String school;
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    //子类重写从基类继承来的方法：方法名称、参数列表、返回类型必须相同；
    // 重写方法的访问权限不能比被重写的方法更严格。
    public String getInfo() {
        return "Name: " + getName() + "\n" + "Age: " + getAge()
                + "\n" + "School: " + school;
     }
}

public class Test8 {
    public static void main(String[] args) {
        Stu s1 = new Stu();
        s1.setName("David");
        s1.setAge(10);
        s1.setSchool("Boston University");
        System.out.println(s1.getInfo());
    }
}
