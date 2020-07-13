import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Start Code

/*
    https://www.hackerrank.com/challenges/java-covariance
*/

class Flower {
// Fields
    public String name;

// Constructors
    public Flower(){
        this("Flower");
    }
    public Flower(String name){
        this.name = name;
    }

// Methods  
    public String whatsYourName(){
        return name;
    }
}

class Jasmine extends Flower{
// Fields

// Constructors
    public Jasmine(){
        super("Jasmine");
    }

// Methods    

}

class Lily extends Flower{
// Fields

// Constructors
    public Lily(){
        super("Lily");
    }

// Methods      

}

/*------------------------------------------------------------------*/

class Region {
// Fields
    private Flower flower;

// Constructors
    public Region(){
        this(new Flower());
    }
    public Region(Flower flower){
        this.flower = flower;
    }

// Methods      
    public Flower yourNationalFlower(){
        return flower;
    }
}

class WestBengal extends Region{
// Fields

// Constructors
    public WestBengal(){
        super(new Jasmine());
    }

// Methods      

}

class AndhraPradesh extends Region{
// Fields

// Constructors
    public AndhraPradesh(){
        super(new Lily());
    }

// Methods    
  
}

// End Code
public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine().trim();
      Region region = null;
      switch (s) {
        case "WestBengal":
          region = new WestBengal();
          break;
        case "AndhraPradesh":
          region = new AndhraPradesh();
          break;
      }
      Flower flower = region.yourNationalFlower();
      System.out.println(flower.whatsYourName());
    }
}