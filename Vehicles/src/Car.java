public class Car extends Vehicle {
// Fields
    private int wheels;
    private int gears;      // -1,0,1,2...
    private int currentGear;
    private boolean engineON;
    private int seats;

// Constructors
    public Car(){
        this("None","None",0.0,0,0,0);
        System.out.println("CONSTRUCTOR: Car()");
    }
    public Car(String name,String energy,double topSpeed,int power,int gears,int seats){
        super(name,1,energy,topSpeed,power);
        this.wheels = 4;
        this.currentGear = 0;
        this.gears = gears;
        this.seats = seats;
        System.out.println("CONSTRUCTOR: Car(...)");
    }

// Getters
    public int getWheels() {
        return wheels;
    }
    public int getGears() {
        return gears;
    }
    public int getCurrentGear() {
        return currentGear;
    }
    public boolean isEngineON() {
        return engineON;
    }
    public int getSeats() {
        return seats;
    }

 // Methods
    public void shiftGear(int newGear){
        System.out.println("METHOD: Car.shiftGear()");
        if(currentGear == newGear)
            System.out.println("\tIneffective Operation\n");
        else if(newGear>=-1 && newGear<=this.gears)
            if (newGear == -1) {
                setCurrentSpeed(0);
                this.currentGear = newGear;
                System.out.println("\tGear Shifted to REVERSE\n");
            }
            else if (newGear == 0) {
                this.currentGear = newGear;
                System.out.println("\tGear Shifted to NEUTRAL\n");
            }
            else {
                if(currentGear == -1)
                    setCurrentSpeed(0);
                this.currentGear = newGear;
                System.out.println("\tGear Shifted to " + newGear + "\n");
            }
        else
            System.out.println("\tIneffective Operation\n");
    }

    @Override
    public void start(){
        System.out.println("METHOD: Car.start()");
        if(!engineON) {
            engineON = true;
            currentGear = 0;
            System.out.println("\t"+getName()+" Started\n");
        }
        else
            System.out.println("\tIneffective Operation\n");
    }

    @Override
    public void stop(){
        System.out.println("METHOD: Car.stop()");
        if(engineON) {
            engineON = false;
            currentGear = 0;
            super.stop();
            System.out.println("\t"+getName()+" Stopped\n");
        }
        else
            System.out.println("\tIneffective Operation\n");
    }

    @Override
    public void accelerate(double increment) {
        System.out.println("METHOD: Car.accelerate()");
        if(engineON)
            super.accelerate(increment);
        else
            System.out.println("\tIneffective Operation\n");
    }

    @Override
    public void decelerate(double decrement) {
        System.out.println("METHOD: Car.decelerate()");
        if(engineON)
            super.decelerate(decrement);
        else
            System.out.println("\tIneffective Operation\n");
    }
}
