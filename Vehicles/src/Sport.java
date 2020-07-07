public class Sport extends Car {
// Fields
    public double nitro;
    public boolean nitroON;

// Constructors
    public  Sport(){
        this("None","None",0.0,0,0,0.0);
        System.out.println("CONSTRUCTOR: Sport()");
    }
    public Sport(String name,String energy,double topSpeed,int power,int gears,double nitro){
        super(name,energy,topSpeed,power,gears,2);
        this.nitro = nitro;
        this.nitroON = false;
        System.out.println("CONSTRUCTOR: Sport(...)");
    }

// Getters
    public double getNitro() {
        return nitro;
    }
    public boolean isNitroON() {
        return nitroON;
    }

 // Methods
    public void startNitro(){
        System.out.println("METHOD: Sport.startNitro()");
        if(!nitroON){
            System.out.println("\tTurning ON Nitro...");
            nitroON = true;
            double speed = getTopSpeed();
            speed *= (100.0+nitro)/100.0;
            setTopSpeed(speed);
            System.out.println("\tTop Speed: "+getTopSpeed()+"\n");
        }
        else
            System.out.println("\tIneffective Operation\n");
    }

    public void stopNitro(){
        System.out.println("METHOD: Sport.stopNitro()");
        if(nitroON){
            System.out.println("\tTurning OFF Nitro...");
            nitroON = false;
            double speed = getTopSpeed();
            speed /= (100.0+nitro)/100.0;
            setTopSpeed(speed);
            System.out.println("\tTop Speed: "+getTopSpeed()+"\n");
        }
        else
            System.out.println("\tIneffective Operation\n");
    }

    @Override
    public void stop() {
        System.out.println("METHOD: Sport.stop()");
        if(nitroON){
            nitroON = false;
            double speed = getTopSpeed();
            speed /= (100.0+nitro)/100.0;
            setTopSpeed(speed);
        }
        super.stop();
    }
}
