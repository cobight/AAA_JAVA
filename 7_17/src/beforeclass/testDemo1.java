package beforeclass;

import java.util.TreeMap;

public class testDemo1 {
    public static void main(String[] args) {
        Circle circle = new Circle("a",3,4);
        System.out.println(circle);
        Rectangle rectangle = new Rectangle("s",5);
        System.out.println(rectangle);
    }
}
abstract class Shape{
    double PI = Math.PI;
    public abstract float getArea();
    public abstract String getName();
}
class Circle extends Shape{
    String name;
    int d,h;
    public Circle(String name,int d, int h) {
        this.name=name;
        this.d = d;
        this.h = h;
    }
    @Override
    public float getArea() {
        return d*h/2;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", Area=" + getArea() +
                '}';
    }
}
class Rectangle extends  Shape{
    String name;
    int r;

    public Rectangle(String name, int r) {
        this.name = name;
        this.r = r;
    }

    @Override
    public float getArea() {
        return Float.parseFloat(String.format("%.2f",(PI*r*r))) ;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name='" + name + '\'' +
                ", Area=" + getArea() +
                '}';
    }
}