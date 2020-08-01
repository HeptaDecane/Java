import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Map<String,String> vocab;
    private static Location newLocation;

    static {

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

        int progress = Data.readProgress();
        newLocation = Data.getLocation(progress);

        System.out.println("\nWelcome to COLOSSAL CAVE ADVENTURE\n");

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
        Location currentLocation;
        while(true){

            currentLocation = newLocation;
            System.out.println(currentLocation.getDescription());

            Map<String,Integer> currentExits = currentLocation.getExits();
            System.out.print("Available Exits: ");
            for(String exit:currentExits.keySet()){
                if(exit.equals("Q"))
                    continue;
                System.out.print(exit+", ");
            }
            System.out.print("Q: Quit()\n");

            String direction = parseInput();
            if(currentExits.containsKey(direction)) {
                int newLocationID = currentExits.get(direction);
                newLocation = Data.getLocation(newLocationID);

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

            if(newLocation.getLocationID() == 0){
                Data.writeProgress(currentLocation.getLocationID());
                System.out.println(newLocation.getDescription());
                break;
            }
        }
    }

}
