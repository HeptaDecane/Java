public class Main {
    public static void main(String[] args) {
        Sport mustang = new Sport("Ford Mustang GT500","Petrol",289,760,7,12);
        System.out.println();

        /* Engine OFF */

            mustang.accelerate(30);
            mustang.decelerate(30);

            mustang.shiftGear(-1);
            System.out.println("# Current Gear: "+mustang.getCurrentGear()+"\n");

            mustang.shiftGear(0);
            System.out.println("# Current Gear: "+mustang.getCurrentGear()+"\n");

            mustang.shiftGear(3);       // Engine OFF
            System.out.println("# Current Gear: "+mustang.getCurrentGear()+"\n");

        mustang.start();
        /* Engine ON */

            System.out.println("# Current Gear: "+mustang.getCurrentGear()+"\n");

            mustang.shiftGear(1);
            mustang.accelerate(10);
            mustang.accelerate(20);

            mustang.shiftGear(2);
            mustang.accelerate(50);

            mustang.shiftGear(3);
            mustang.accelerate(90);

            mustang.shiftGear(4);
            mustang.accelerate(120);
            mustang.accelerate(30);

            System.out.println("# Top Speed: "+mustang.getTopSpeed()+"\n");

            mustang.startNitro();

            mustang.accelerate(10);
            mustang.accelerate(20);

            mustang.stopNitro();

            System.out.println("# Current Speed: "+mustang.getCurrentSpeed()+"\n");

            mustang.accelerate(40);

            mustang.decelerate(50);

            mustang.shiftGear(3);
            mustang.decelerate(80);

            mustang.shiftGear(2);
            mustang.decelerate(90);
            mustang.decelerate(100);
            mustang.decelerate(10);

            mustang.shiftGear(-1);
            mustang.accelerate(30);
            mustang.decelerate(30);

        mustang.stop();
        /* Engine OFF */

            System.out.println("# Current Speed: "+mustang.getCurrentSpeed()+"\n");
            System.out.println("# Current Gear: "+mustang.getCurrentGear()+"\n");

    }
}
