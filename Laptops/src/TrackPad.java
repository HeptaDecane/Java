public class TrackPad {
// Fields
    private String type;
    private String model;
    private boolean active;

// Constructors
    public TrackPad(String model,String type){
        this.model = model;
        this.type = type;
        this.active = false;
    }

// Methods
    public void powerON(){
        System.out.println("METHOD: Trackpad.powerON()");
        active = true;
        System.out.println("\tTrackpad: Active\n");

    }

    public void powerOFF(){
        System.out.println("METHOD: Trackpad.powerOFF()");
        active = false;
        System.out.println("\tTrackpad: Inactive\n");
    }
}
