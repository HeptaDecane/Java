import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class Data {

    public static Map<Integer,Location> readMap(){
        System.out.print("Loading Map...");

        Map<Integer,Location> map = new LinkedHashMap<>();
        Path locationsFile = FileSystems.getDefault().getPath("locations.txt");
        Path exitsFile = FileSystems.getDefault().getPath("exits.txt");

        try(Scanner scanner = new Scanner(Files.newBufferedReader(locationsFile))){
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int locationID = scanner.nextInt();
                scanner.skip(",");
                String description = scanner.nextLine();
                map.put(locationID,new Location(locationID,description));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try(Scanner scanner = new Scanner(Files.newBufferedReader(exitsFile))){
            while(scanner.hasNextLine()){
                String str = scanner.nextLine();
                String[] data = str.split(",");
                int locationID = Integer.parseInt(data[0]);
                String direction = data[1];
                int exitsTo = Integer.parseInt(data[2]);
                map.get(locationID).addExit(direction,exitsTo);
            }
        } catch (Exception e){
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
        Path locationsFile = FileSystems.getDefault().getPath("locations.txt");
        Path exitsFile = FileSystems.getDefault().getPath("exits.txt");
        try(
            BufferedWriter locationsBuffer = Files.newBufferedWriter(locationsFile);
            BufferedWriter exitsBuffer = Files.newBufferedWriter(exitsFile)
        ){
            for(Location location: map.values()) {
                locationsBuffer.write(location.getLocationID()+ "," );
                locationsBuffer.write(location.getDescription() + "\n");

                for(String direction:location.getExits().keySet()){
                    if(direction.equals("Q"))
                        continue;
                    exitsBuffer.write(location.getLocationID()+",");
                    exitsBuffer.write(direction+",");
                    exitsBuffer.write(location.getExits().get(direction)+"\n");

                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
