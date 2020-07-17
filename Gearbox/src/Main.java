public class Main {
    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox("mc3294",6);

        //    Direct Access to Inner Class
        //    Gearbox.Gear test = mcLaren.new Gear(20,0);

        mcLaren.operateClutch();
        mcLaren.changeGear(0);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(1);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(2);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(3);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(4);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(5);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(6);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(-1);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.changeGear(3);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.changeGear(2);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

        mcLaren.operateClutch();
        mcLaren.changeGear(7);
        System.out.println("RPM: "+mcLaren.wheelSpeed(100)+"\n");

    }
}
