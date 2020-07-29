import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Map<Integer,Location> map;
    private static Map<String,String> vocab;
    private static Map<String,Integer> exits;

    static {
        map = new HashMap<>();
        vocab = new HashMap<>();

        exits = new LinkedHashMap<>();
        Location home = new Location(0,"Quit()",exits);
        map.put(0,home);

        exits = new LinkedHashMap<>();
        exits.put("N",5);
        exits.put("S",4);
        exits.put("E",3);
        exits.put("W",2);
        Location road = new Location(1,"Road",exits);
        map.put(1,road);

        exits = new LinkedHashMap<>();
        exits.put("E",5);
        Location hill = new Location(2,"Hill",exits);
        map.put(2,hill);

        exits = new LinkedHashMap<>();
        exits.put("W",1);
        Location building = new Location(3,"Building",exits);
        map.put(3,building);

        exits = new LinkedHashMap<>();
        exits.put("N",1);
        exits.put("W",2);
        Location valley = new Location(4,"Valley",exits);
        map.put(4,valley);

        exits = new LinkedHashMap<>();
        exits.put("W",2);
        exits.put("S",1);
        Location forest = new Location(5,"Forest",exits);
        map.put(5,forest);

        vocab.put("QUIT","Q");
        vocab.put("NORTH","N");
        vocab.put("SOUTH","S");
        vocab.put("EAST","E");
        vocab.put("WEST","W");
    }

    public static String  parseInput(){
        String phrase = input.nextLine().toUpperCase();
        if(phrase.length()>1){
            String[] words = phrase.split(" ");
            for(String word:words){
                if(vocab.containsKey(word)){
                    return vocab.get(word);
                }
            }
        }
        return phrase;
    }

    public static void main(String[] args) {
        int locationID = 1;
        while(true){

            if(locationID == 0){
                System.out.println(map.get(locationID).getDescription());
                break;
            }
            System.out.println("You've reached "+map.get(locationID).getDescription());

            Map<String,Integer> currentExits = map.get(locationID).getExits();
            System.out.print("Available Exits: ");
            for(String exit:currentExits.keySet()){
                if(exit.equals("Q"))
                    continue;
                System.out.print(exit+", ");
            }
            System.out.print("Q: Quit()\n");

            String direction = parseInput();
            if(currentExits.containsKey(direction)) {
                locationID = currentExits.get(direction);
                switch (direction){
                    case "N":
                        System.out.println("Heading NORTH...\n");
                        break;
                    case "S":
                        System.out.println("Heading SOUTH...\n");
                        break;
                    case "E":
                        System.out.println("Heading EAST...\n");
                        break;
                    case "W":
                        System.out.println("Heading WEST..\n");
                        break;
                }
            }
            else
                System.out.println("No Exits in that direction\n");
        }
    }
}
