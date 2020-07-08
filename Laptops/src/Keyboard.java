public class Keyboard {
// Fields
    private String type;
    private String model;
    private boolean active;

// Constructors
    public Keyboard(String model,String type){
        this.model = model;
        this.type = type;
        this.active = false;
    }

// Methods
    public void powerON(){
        System.out.println("METHOD: Keyboard.powerON()");
        active = true;
        System.out.println("\tKeyboard: Active\n");

    }

    public void powerOFF(){
        System.out.println("METHOD: Keyboard.powerOFF()");
        active = false;
        System.out.println("\tKeyboard: Inactive\n");
    }
}
