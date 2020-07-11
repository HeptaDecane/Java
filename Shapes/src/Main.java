import java.text.DecimalFormat;

public class Main {
    public static DecimalFormat decimal = new DecimalFormat("0.000");
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.draw();
        System.out.println("Area: "+decimal.format(shape.area()));
        System.out.println("Perimeter: "+decimal.format(shape.perimeter()));
        System.out.println("Circumference: "+decimal.format(shape.circumference())+"\n");

        shape = new Rectangle(30,50);
        shape.draw();
        System.out.println("Area: "+decimal.format(shape.area()));
        System.out.println("Perimeter: "+decimal.format(shape.perimeter())+"\n");

        shape = new Circle(40);
        shape.draw();
        System.out.println("Area: "+decimal.format(shape.area()));
        System.out.println("Circumference: "+decimal.format(shape.circumference())+"\n");

        shape = new Triangle(30,40,50);
        shape.draw();
        System.out.println("Area: "+decimal.format(shape.area()));
        System.out.println("Perimeter: "+decimal.format(shape.perimeter())+"\n");
    }
}