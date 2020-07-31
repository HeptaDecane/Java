import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public static void initialConversion(Map<Integer,Location> map){
        try(RandomAccessFile file = new RandomAccessFile("record.dat","rwd")) {
            file.writeInt(map.size());

            int indexSize = map.size()*3*Integer.BYTES;
            int locationStart = indexSize + (int)file.getFilePointer() + Integer.BYTES;
            /*
                indexSize: Bytes required to store indices
                file.getFilePointer(): current file pointer;
                Integer.BYTES: Bytes required to write location Start (line 82)
             */
            file.writeInt(locationStart);

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
