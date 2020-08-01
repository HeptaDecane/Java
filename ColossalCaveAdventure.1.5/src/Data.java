import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class Data {

    public static Map<Integer,Location> readMap(){
        System.out.print("Loading Map.");

        Map<Integer,Location> map = new LinkedHashMap<>();
        Path path =  FileSystems.getDefault().getPath("map.dat");

        try(
            InputStream file = Files.newInputStream(path);
            BufferedInputStream buffer = new BufferedInputStream(file);
            ObjectInputStream iStream = new ObjectInputStream(buffer)
        ){
            while(true){
                Location location = (Location) iStream.readObject();
                map.put(location.getLocationID(),location);
            }
        }catch (EOFException e){
            System.out.print("..");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("SUCCESS");

        return map;
    }

    public static int readProgress(){
        System.out.print("Loading Progress...");
        int currentLocationID = 1;

        Path file = FileSystems.getDefault().getPath("progress.txt");
        try(Scanner scanner = new Scanner(Files.newBufferedReader(file))){
            currentLocationID = scanner.nextInt();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("SUCCESS");
        return currentLocationID;
    }

    public static void writeProgress(int locationID){
        System.out.print("Saving Progress...");
        Path file = FileSystems.getDefault().getPath("progress.txt");
        try(BufferedWriter oStream = Files.newBufferedWriter(file)) {
            oStream.write(Integer.toString(locationID));
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("SUCCESS");
    }

    public static void initialConversion(Map<Integer,Location> map){
        Path path = FileSystems.getDefault().getPath("map.dat");
        try(
            OutputStream file = Files.newOutputStream(path);
            BufferedOutputStream buffer = new BufferedOutputStream(file);
            ObjectOutputStream oStream = new ObjectOutputStream(buffer);
        ){
            for(Location location:map.values())
                oStream.writeObject(location);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
