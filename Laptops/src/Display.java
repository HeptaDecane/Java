public class Display {
// Fields
    private int height;
    private int width;
    private int horizontalPixels;
    private int verticalPixels;
    private String model;
    private boolean active;

// Constructors
    public Display(String model,int height,int width,int horizontalPixels,int verticalPixels){
        this.model = model;
        this.height = height;
        this.width = width;
        this.horizontalPixels = horizontalPixels;
        this.verticalPixels = verticalPixels;
        this.active = false;
    }

// Methods
    public void powerON(String brand){
        System.out.println("METHOD: Display.powerON()");
        active = true;
        System.out.println("\tDisplay: Active");
        System.out.println("\t"+brand+" Logo\n");
    }

    public void powerOFF(String brand){
        System.out.println("METHOD: Display.powerOFF()");
        System.out.println("\t "+brand+" Logo");
        active = false;
        System.out.println("\tDisplay: Inactive\n");
    }
}
