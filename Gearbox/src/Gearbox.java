import java.util.ArrayList;
import java.util.List;

public class Gearbox {
    private String modelName;
    private int currentGear;
    private boolean clutchIn;
    private List<Gear> gears;
    private int noOfGears;

    public Gearbox(String modelName,int noOfGears){
        this.modelName = modelName;
        this.noOfGears = noOfGears;
        currentGear = 0;
        clutchIn = false;
        gears = new ArrayList<>();
        for(int i=0;i<=noOfGears;i++)
            gears.add(new Gear(i,i*5.3));

        Gear reverse = new Gear(noOfGears,-5.3);
        gears.add(reverse);
    }

    public void operateClutch(){
        clutchIn = true;
    }

    public void changeGear(int gearNo){
        if(!clutchIn){
            currentGear = 0;
            System.out.println("Gear Change Failed: Clutch Not Engaged");
            System.out.println("Gear Shifted to Neutral");
            return;
        }
        if(gearNo==-1){
            currentGear = gears.size()-1;
            System.out.println("Gear Shifted to Reverse");
        }
        else if(gearNo>=0 && gearNo<gears.size()-1){
            currentGear = gearNo;
            if(gearNo==0)
                System.out.println("Gear Shifted to Neutral");
            else
                System.out.println("Gear Shifted to "+gearNo);
        }
        else {
            currentGear = 0;
            System.out.println("Gear Change Failed: Invalid Gear");
            System.out.println("Gear Shifted to Neutral");
        }
        clutchIn = false;
        return;
    }

    public int wheelSpeed(int revs){
        if(clutchIn) {
            System.out.println("Clutch Engaged");
            return 0;
        }
        double ratio = gears.get(currentGear).getRatio();
        return (int)(ratio*revs);
    }

    private class Gear{
        private int number;
        private double ratio;

        public Gear(int number,double ratio){
            this.number = number;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }
    }
}
