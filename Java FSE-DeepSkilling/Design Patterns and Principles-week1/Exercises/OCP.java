// Exercise 2 - OCP (Open/Closed Principle)
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}

class AreaCalculator {
    public double totalArea(Shape[] shapes) {
        double area = 0;
        for (Shape s : shapes) {
            area += s.calculateArea();
        }
        return area;
    }
}

public class OCP {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(3.0),
            new Rectangle(4.0, 5.0)
        };

        AreaCalculator calculator = new AreaCalculator();
        double total = calculator.totalArea(shapes);
        System.out.println("Total area: " + total);
    }
}
