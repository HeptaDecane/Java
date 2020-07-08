public class ProcessingUnit {
// Fields
    private int ram;
    private int memory;
    private BIOS bios;
    private String processor;
    private int cores;
    private String model;
    private boolean active;

// Constructor
    public ProcessingUnit(String model,String processor,int cores,int ram,int memory,BIOS bios){
        this.model = model;
        this.processor = processor;
        this.cores = cores;
        this.ram = ram;
        this.memory = memory;
        this.bios = bios;
        this.active = false;
    }

// Methods
    public void powerON(){
        System.out.println("METHOD: ProcessingUnit.powerON()");
        active = true;
        System.out.println("\tProcessing Unit: Active\n");
        bios.load();
    }

    public void powerOFF(){
        System.out.println("METHOD: ProcessingUnit.powerOFF()");
        bios.unload();
        active = false;
        System.out.println("\tProcessing Unit: Inactive\n");
    }

    public void installOS(OS os){
        bios.setOS(os);
    }
}
