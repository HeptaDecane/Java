import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class Data {
    public static Map<Integer,Location> read(){
        Map<Integer,Location> map = new LinkedHashMap<>();
        Map<String,Integer> exits = new HashMap<>();

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

//        for(Location location:map.values()){
//            System.out.println(location.getLocationID()+" | "+location.getDescription());
//            exits = location.getExits();
//            for(String key:exits.keySet())
//                System.out.println("\t"+key+" "+exits.get(key));
//            System.out.println();
//        }

        System.out.println("Map Loading Completed...");
        return map;
    }
    public static void write(){
        try(BufferedWriter file = new BufferedWriter(new FileWriter("testFile.txt"))) {
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
