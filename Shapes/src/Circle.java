public class Circle extends Shape {
// Fields
    double radius;

// Constructors
    public Circle(){
        this(0.0);
    }
    public Circle(double radius){
        super();
        this.radius = radius;
    }

// Methods
    @Override
    public void draw(){
        System.out.println("Circle: "+radius);
    }

    @Override
    public double area(){
        return 3.1415*radius*radius;
    }

    public double circumference(){
        return  2*3.1415*radius;
    }
}


