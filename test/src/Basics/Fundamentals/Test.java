package Basics.Fundamentals;

/**
 *  A class that represents a point in 3D space
 */

class Point_1 {
    private double x;
    private double y;
    private double z;

    Point_1() {  }

    Point_1(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDistance() {
        return x * x + y * y + z * z;
    }

    public void display() {
        System.out.println(x + "," + y + "," + z);
    }
}

public class Test {

    public static void main(String[] args) {
        Point_1 p1 = new Point_1();
        Point_1 p2 = new Point_1(3,4,5);
        System.out.println(p2.getDistance());
        p1.setX(2);
        p1.display();
        p2.display();
    }
}
