public class Rectangle extends Shape {
// Fields
    double width;
    double height;

// Constructors
    public Rectangle(){
        this(0.0,0.0);
    }
    public Rectangle(double width,double height){
        super();
        this.height = height;
        this.width = width;
    }

// Methods
    @Override
    public void draw(){
        System.out.println("Rectangle: "+width+" x "+height);
    }

    @Override
    public double area(){
        return width*height;
    }

    @Override
    public double perimeter(){
        return 2*(width+height);
    }
}
