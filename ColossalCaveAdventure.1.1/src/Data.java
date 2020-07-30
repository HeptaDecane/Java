import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Data {

    public static Map<Integer,Location> readMap(){
        System.out.print("Loading Map.");

        Map<Integer,Location> map = new LinkedHashMap<>();
        Map<String,Integer> exits = new HashMap<>();
        // Reading Locations
        try(
            FileInputStream file = new FileInputStream("locations.dat");
            BufferedInputStream buffer = new BufferedInputStream(file);
            DataInputStream iStream = new DataInputStream(buffer)
        ){
            while(true){
                int locationID = iStream.readInt();
                String description = iStream.readUTF();
                map.put(locationID,new Location(locationID,description,exits));
            }
        }catch(EOFException e){
            System.out.print(".");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        // Reading Exits
        try(
            FileInputStream file = new FileInputStream("exits.dat");
            BufferedInputStream buffer = new BufferedInputStream(file);
            DataInputStream iStream = new DataInputStream(buffer)
        ){
            while(true){
                int locationID = iStream.readInt();
                String direction = iStream.readUTF();
                int exitsTo = iStream.readInt();

                Location location = map.get(locationID);
                location.addExit(direction,exitsTo);
            }
        }catch(EOFException e){
            System.out.print(".");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("SUCCESS");
        return map;
    }

    public static int readProgress(){
        System.out.print("Loading Progress...");

        int currentLocationID = 1;
        try(
            FileInputStream file = new FileInputStream("progress.dat");
            DataInputStream iStream = new DataInputStream(file)
        ){
            currentLocationID = iStream.readInt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("SUCCESS");
        return currentLocationID;
    }

    public static void writeProgress(int locationID){
        System.out.print("Saving Progress...");
        try(
            FileOutputStream file = new FileOutputStream("progress.dat");
            DataOutputStream oStream = new DataOutputStream(file)
        ) {
            oStream.writeInt(locationID);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("SUCCESS");
    }

}
