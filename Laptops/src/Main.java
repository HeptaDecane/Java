public class Main {
    public static void main(String[] args) {
        ProcessingUnit intel = new ProcessingUnit("8250U","i5",8,8,2048,new BIOS("1.5.0"));
        Display display = new Display("LED 3000",260,380,1920,1080);
        Keyboard keyboard = new Keyboard("KEY 3000","QWERTY + Num");
        TrackPad trackPad = new TrackPad("PTR 3000","Area");

        Laptop inspiron = new Laptop("Dell","INS 3576",intel,display,keyboard,trackPad);

        OS ubuntu = new OS("Ubuntu","Linux","18.04 Bionic");

        System.out.println();

//        inspiron.powerON();
//        System.out.println("\n");
//        inspiron.powerOFF();

        inspiron.installOS(ubuntu);

        inspiron.powerON();
        System.out.println("\n");
        inspiron.powerOFF();
    }
}
