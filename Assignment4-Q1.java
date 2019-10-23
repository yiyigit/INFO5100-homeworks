import java.awt.*;
import java.lang.Math;

public class Shape {
    protected String name;
    protected double perimeter;
    protected double area;

    public void draw(){
        System.out.println("Drawing " + getName());
    };
    public void getArea(){
        System.out.println(area);
    };
    public void getPerimeter(){
        System.out.println(perimeter);
    };
    public String getName(){
        return getClass().getSimpleName();
    }
}




class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(double w, double h){
        this.width = w;
        this.height = h;
        this.perimeter = 2*(width + height);
        this.area = width * height;
    }

}
class Circle extends Shape{
    private double radius;
    public Circle(double r){
        this.radius = r;
        this.perimeter = Math.round(radius * 2 * Math.PI*100.0) /100.0;
        this.area = Math.round(Math.PI * radius * radius *100.0) / 100.0;
    }

}
class Square extends Shape{
    private double line;
    public Square(double l) {
        this.line = l;
        this.perimeter = 4 * line;
        this.area = line * line;
    }

}

public class ShapeTest {
    public static void main(String[] args) {
        Shape s = new Shape();
        Rectangle r = new Rectangle(2.0,3.0);
        Circle c = new Circle(4.0);
        Square sq = new Square(4.0);
        r.getArea();
        r.getPerimeter();
        c.getArea();
        c.getPerimeter();
        sq.getArea();
        sq.getPerimeter();
        r.draw();
        c.draw();
        s.draw();
        sq.draw();

    }


}
