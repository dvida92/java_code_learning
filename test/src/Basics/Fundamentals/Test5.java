package Basics.Fundamentals;

/**
 * Analysis of Ram Part II
 */

class Point {
    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {  return x; }
    public double getY() {  return y; }

    public void setX(double i) {  x = i;  }
    public void setY(double i) {  y = i;  }
}

class Circle {
    private Point o;
    private double radius;

    Circle(Point p, double r) {
        o = p;
        radius = r;
    }

    Circle(double r) {
        o = new Point(0, 0);
        radius = r;
    }

    public void setO(double x, double y) {
        o.setX(x);
        o.setY(y);
    }

    public Point getO() {
        return o;
    }
}


public class Test5 {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(1,2), 2); //Analyze RAM allocation
        Circle c2 = new Circle(5.0);
        System.out.println(c1.getO().getX()); //Analyze RAM allocation: c1.get0() return a Point type in stack and it points to a structure in Heap seg
    }
}
