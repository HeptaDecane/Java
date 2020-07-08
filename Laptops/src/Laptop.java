public class Laptop {
// Fields
    String brand;
    String model;
    ProcessingUnit processingUnit;
    Display display;
    Keyboard keyboard;
    TrackPad trackPad;
    private boolean active;

// Constructors
    public Laptop(String brand,String model,ProcessingUnit processingUnit,Display display,Keyboard keyboard,TrackPad trackPad){
        this.brand = brand;
        this.model = model;
        this.processingUnit = processingUnit;
        this.display = display;
        this.keyboard = keyboard;
        this.trackPad = trackPad;
        this.active = false;
    }


// Methods
    public void powerON(){
        System.out.println("METHOD: Laptop.powerON()");
        active = true;
        System.out.println("\tLaptop: Active\n");
        display.powerON(brand);
        processingUnit.powerON();
        keyboard.powerON();
        trackPad.powerON();
    }

    public void powerOFF(){
        System.out.println("METHOD: Laptop.powerOFF()");
        processingUnit.powerOFF();
        trackPad.powerOFF();
        keyboard.powerOFF();
        display.powerOFF(brand);
        active = false;
        System.out.println("\tLaptop: Inactive\n");
    }

    public void installOS(OS os){
        processingUnit.installOS(os);
    }
}
