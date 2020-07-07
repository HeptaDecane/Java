public class Vehicle {
// Fields
    private String name;
    private int means;      // [ 1:Land | 2:Water | 3:Air ]
    private String energy;
    private double topSpeed;
    private double currentSpeed;
    private int power;

// Constructors
    public Vehicle(){
        this("None",0,"None",0.0,0);
        System.out.println("CONSTRUCTOR: Vehicle()");

    }
    public Vehicle(String name,int means,String energy,double topSpeed,int power){
        this.name = name;
        if(means==1 || means==2 || means==3)
            this.means = means;
        else
            this.means = 0;
        this.energy = energy;
        this.topSpeed = topSpeed;
        this.power = power;
        this.currentSpeed = 0;
        System.out.println("CONSTRUCTOR: Vehicle(...)");
    }

// Getters
    public String getName() {
        return name;
    }
    public int getMeans() {
        return means;
    }
    public String getEnergy() {
        return energy;
    }
    public double getTopSpeed() {
        return topSpeed;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public int getPower() {
        return power;
    }

//Setters
    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }
    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed =currentSpeed;
    }

// Methods;
    public void start(){
        System.out.println("METHOD: Vehicle.start()");
    }

    public void stop(){
        System.out.println("METHOD: Vehicle.stop()");
        currentSpeed = 0;
    }

    public void accelerate(double increment){
        System.out.println("METHOD: Vehicle.accelerate()");
        if(currentSpeed >= topSpeed)
            System.out.println("\tIneffective Operation");
        else if(currentSpeed+increment < topSpeed)
            currentSpeed += increment;
        else
            currentSpeed = topSpeed;
        System.out.println("\tCurrent Speed: " + currentSpeed+"\n");
    }

    public void decelerate(double decrement){
        System.out.println("METHOD: Vehicle.decelerate()");
        if(currentSpeed <= 0)
            System.out.println("\tIneffective Operation");
        else if(currentSpeed > decrement)
            currentSpeed -= decrement;
        else
            currentSpeed = 0;
        System.out.println("\tCurrent Speed: " + currentSpeed+"\n");
    }


}
