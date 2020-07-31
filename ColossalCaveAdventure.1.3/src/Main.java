import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Map<Integer,Location> map;
    private static Map<String,String> vocab;
    private static int newLocationID;

    static {
        map = Data.readMap();

        System.out.print("Loading Vocabulary...");
        vocab = new HashMap<>();
        vocab.put("QUIT","Q");
        vocab.put("NORTH","N");
        vocab.put("SOUTH","S");
        vocab.put("EAST","E");
        vocab.put("WEST","W");
        vocab.put("DOWN","D");
        vocab.put("UP","U");
        vocab.put("NORTH-EAST","NE");
        vocab.put("NORTH-WEST","NW");
        vocab.put("SOUTH-EAST","SE");
        vocab.put("SOUTH-WEST","SW");
        System.out.println("SUCCESS");

        newLocationID = Data.readProgress();

        System.out.println("\nWelcome to COLOSSAL CAVE ADVENTURE\n");

        Data.initialConversion(map);
    }

    public static String parseInput(){
        String phrase = input.nextLine().toUpperCase();
        String[] words = phrase.split(" ");
        for(String word:words){
            if(vocab.containsKey(word)){
                return vocab.get(word);
            }
        }
        return phrase;
    }

    public static void main(String[] args) {
        int currentLocationID;
        while(true){

            currentLocationID = newLocationID;
            System.out.println(map.get(currentLocationID).getDescription());

            Map<String,Integer> currentExits = map.get(currentLocationID).getExits();
            System.out.print("Available Exits: ");
            for(String exit:currentExits.keySet()){
                if(exit.equals("Q"))
                    continue;
                System.out.print(exit+", ");
            }
            System.out.print("Q: Quit()\n");

            String direction = parseInput();
            if(currentExits.containsKey(direction)) {
                newLocationID = currentExits.get(direction);
                for(String key:vocab.keySet()){
                    if(direction.equals(vocab.get(key))){
                        if(key.equals("UP") || key.equals("DOWN"))
                            System.out.println("Heading "+key+"WARDS...\n");
                        else if(key.equals("QUIT"))
                            continue;
                        else
                            System.out.println("Heading "+key+"...\n");
                        break;
                    }
                }
            }
            else
                System.out.println("No Exits in that direction\n");

            if(newLocationID == 0){
                Data.writeProgress(currentLocationID);
                System.out.println(map.get(newLocationID).getDescription());
                break;
            }
        }
    }

}
