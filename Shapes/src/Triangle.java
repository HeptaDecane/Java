public class Triangle extends Shape {
// Fields
    double sideA;
    double sideB;
    double sideC;

// Constructors
    public Triangle(){
        this(0.0,0.0,0.0);

    }
    public Triangle(double sideA,double sideB,double sideC){
        super();
        if(sideA+sideB>sideC || sideB+sideC>sideA || sideC+sideA>sideB) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        else
            System.out.println("Invalid Sides");
    }

// Methods
    @Override
    public void draw(){
        System.out.println("Triangle: "+sideA+", "+sideB+", "+sideC);
    }

    @Override
    public double area(){
        double s = (sideA+sideB+sideC)/2;
        return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
    }

    @Override
    public double perimeter(){
        return sideA+sideB+sideC;
    }
}
