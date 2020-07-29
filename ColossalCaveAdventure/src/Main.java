import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Map<Integer,Location> map;
    private static Map<String,String> vocab;

    static {
        map = Data.read();
        vocab = new HashMap<>();



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
            System.out.println(map.get(locationID).getDescription());

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
