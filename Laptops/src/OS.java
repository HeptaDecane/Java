public class OS {
// Fields
    private String name;
    private String kernel;
    private String version;
    private boolean active;

// Constructors
    public OS(String name, String kernel, String version) {
        this.name = name;
        this.kernel = kernel;
        this.version = version;
        this.active = false;
    }

// Methods
    public void boot(){
        System.out.println("METHOD: OS.boot()");
        active = true;
        System.out.println("\tOS: Active");
        System.out.println("\t"+name+" "+version+" Logo");
        System.out.println("\tWelcome Screen\n");
    }

    public void shutDown(){
        System.out.println("METHOD: OS.shutDown()");
        System.out.println("\tShutting Down Screen");
        active = false;
        System.out.println("\tOS: Inactive\n");
    }
}
