import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class Data {
    public static Map<Integer,Location> readMap(){
        System.out.print("Loading Map...");

        Map<Integer,Location> map = new LinkedHashMap<>();
        Map<String,Integer> exits = new HashMap<>();
        // Reading Locations
        try(
            FileReader file = new FileReader("locations.txt");
            BufferedReader buffer = new BufferedReader(file);
            Scanner scanner = new Scanner(buffer);
        ){
            while(scanner.hasNextLine()){
                scanner.useDelimiter(",");
                int locationID = scanner.nextInt();
                scanner.skip(",");
                String description = scanner.nextLine();
                map.put(locationID,new Location(locationID,description,exits));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        // Reading Exits
        try(
            FileReader file = new FileReader("exits.txt");
            BufferedReader buffer = new BufferedReader(file);
            Scanner scanner = new Scanner(buffer);
        ){
            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",");
                int locationID = Integer.parseInt(data[0]);
                String direction = data[1];
                int exitsTo = Integer.parseInt(data[2]);

                Location location = map.get(locationID);
                location.addExit(direction,exitsTo);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println("SUCCESS");
        return map;
    }

    public static int readProgress(){
        System.out.print("Loading Progress...");

        int currentLocationID = 1;
        try(
            FileReader file = new FileReader("progress.txt");
            Scanner scanner = new Scanner(file);
        ){
            currentLocationID = scanner.nextInt();
        }catch (Exception e){
            System.out.println(e);
            currentLocationID = 1;
        }

        System.out.println("SUCCESS");
        return currentLocationID;
    }

    public static void writeProgress(int locationID){
        System.out.print("Saving Progress...");
        try(
            FileWriter file = new FileWriter("progress.txt");
            BufferedWriter buffer = new BufferedWriter(file);
        ) {
            buffer.write(Integer.toString(locationID));
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("SUCCESS");
    }

}
