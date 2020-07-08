public class BIOS {
// Fields
    private String version;
    private boolean active;
    private OS os;

// Constructor
    public BIOS(String version){
        this.version = version;
        this.os = null;
        this.active = false;
    }

// Methods
    public void load(){
        System.out.println("METHOD: BIOS.load()");
        active = true;
        System.out.println("\tBIOS: Active");
        if(os != null)
            os.boot();
        else
            System.out.println("\tBoot Sequence Missing\n");
    }

    public void unload(){
        System.out.println("METHOD: BIOS.unload()");
        if(os != null)
            os.shutDown();
        active = false;
        System.out.println("\tBIOS: Inactive\n");
    }

    public void setOS(OS os){
        this.os = os;
    }
}
