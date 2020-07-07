public class Sedan extends Car{
// Fields
    double luggageSpace;
    double userRating;

// Constructors
    public Sedan(){
        this("None","None",0.0,0,0,0.0,0.0);
        System.out.println("CONSTRUCTOR: Sedan()");

    }
    public Sedan(String name,String energy,double topSpeed,int power,int gears,double luggageSpace,double userRating){
        super(name,energy,topSpeed,power,gears,4);
        this.luggageSpace = luggageSpace;
        this.userRating = userRating;
        System.out.println("CONSTRUCTOR: Sedan(...)");
    }

// Getters
    public double getLuggageSpace() {
        return luggageSpace;
    }
    public double getUserRating() {
        return userRating;
    }
}
