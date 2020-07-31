import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Data {

    public static Map<Integer,Location> readMap(){
        System.out.print("Loading Map.");

        Map<Integer,Location> map = new LinkedHashMap<>();

        try(
            FileInputStream file = new FileInputStream("map.dat");
            BufferedInputStream buffer = new BufferedInputStream(file);
            ObjectInputStream iStream = new ObjectInputStream(buffer)
        ){
            while (true){
                Location location = (Location) iStream.readObject();
                map.put(location.getLocationID(),location);
            }
        }catch (EOFException e){
            System.out.print("..");
        }
        catch (Exception e){
            System.out.println(e);
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
            System.out.println(e);
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
            System.out.println(e);
        }
        System.out.println("SUCCESS");
    }

    public static void convertToObjects(Map<Integer,Location> map){
        try(
            FileOutputStream file = new FileOutputStream("map.dat");
            BufferedOutputStream buffer = new BufferedOutputStream(file);
            ObjectOutputStream oStream = new ObjectOutputStream(buffer)
        ) {
           for(int locationID:map.keySet())
               oStream.writeObject(map.get(locationID));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
