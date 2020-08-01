import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class Data {
    private static class Index{
        private int start;
        private int length;

        private Index(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }
    private static Map<Integer,Index> index = new LinkedHashMap<>();

    static {
        // Load Indices into memory
        try(RandomAccessFile file = new RandomAccessFile("record.dat","rwd")){
            int n = file.readInt();     // No. of locations
            int locationStart = file.readInt();
            while(file.getFilePointer()<locationStart){
                int locationID = file.readInt();
                int start = file.readInt();
                int length = file.readInt();

                Index record = new Index(start,length);
                index.put(locationID,record);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Location getLocation(int locationID){
        try(RandomAccessFile file = new RandomAccessFile("record.dat","rwd")){
            Index record = index.get(locationID);
            file.seek(record.start);

            locationID = file.readInt();
            String description = file.readUTF();
            Location location = new Location(locationID,description);

            String str = file.readUTF();
            String[] exits = str.split(",");
            for(int i=0;i<exits.length;i+=2){
                String direction = exits[i];
                int exitsTo = Integer.parseInt(exits[i+1]);
                location.addExit(direction,exitsTo);
            }
            return location;
        }catch (Exception e){
            System.out.println(e);
        }
        // If can't retrieve requested location
        return getLocation(0);
    }


    public static int readProgress(){
        System.out.print("Loading Progress...");
        int currentLocationID = 1;
        try(Scanner scanner = new Scanner(new FileReader("progress.txt"))){
            currentLocationID = scanner.nextInt();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("SUCCESS");

        return currentLocationID;
    }

    public static void writeProgress(int locationID){
        System.out.print("Saving Progress...");
        try(FileWriter file = new FileWriter("progress.txt")) {
            file.write(Integer.toString(locationID));
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("SUCCESS");
    }

    public static void initialConversion(Map<Integer,Location> map){
        try(RandomAccessFile file = new RandomAccessFile("record.dat","rwd")) {
            file.writeInt(map.size());

            int indexSize = map.size()*3*Integer.BYTES;
            int locationStart = indexSize + (int)file.getFilePointer() + Integer.BYTES;
            /*
                indexSize: Bytes required to store indices
                file.getFilePointer(): current file pointer;
                Integer.BYTES: Bytes required to write location Start (line#)
             */
            file.writeInt(locationStart);       // line#

            int indexStart = (int)file.getFilePointer();

            int startPointer = locationStart;
            file.seek(startPointer);

            for(Location location:map.values()){
                System.out.println("Writing Location #"+location.getLocationID());

                file.writeInt(location.getLocationID());
                file.writeUTF(location.getDescription());

                StringBuilder str = new StringBuilder();
                Map<String,Integer> exits = location.getExits();
                for(String direction:exits.keySet()){
                    str.append(direction);
                    str.append(",");
                    str.append(exits.get(direction));
                    str.append(",");
                }
                file.writeUTF(str.toString());

                Index record = new Index(startPointer,(int)(file.getFilePointer()-startPointer));
                index.put(location.getLocationID(),record);

                startPointer = (int)file.getFilePointer();
            }

            file.seek(indexStart);
            for(int locationID:index.keySet()){
                System.out.println("Writing Index #"+locationID);

                file.writeInt(locationID);
                file.writeInt(index.get(locationID).start);
                file.writeInt(index.get(locationID).length);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
