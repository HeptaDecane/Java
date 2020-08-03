import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main1 {
    public static void main(String[] args) {
        try(
            RandomAccessFile file = new RandomAccessFile("data.dat","rwd");
            FileChannel fileChannel = file.getChannel();
        ){
            byte[] stringBytes = "helloWorld".getBytes();

            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.putInt(66);
            buffer.putInt(67);
            buffer.putInt(68);
            buffer.flip();
            fileChannel.write(buffer);
//            buffer.flip();
            RandomAccessFile file1 = new RandomAccessFile("data.dat","rwd");
            FileChannel fileChannel1 = file.getChannel();
            ByteBuffer buffer0 = ByteBuffer.allocate(100);
            fileChannel1.read(buffer0);
//            buffer0.flip();
            System.out.println(buffer0);
            System.out.println(buffer.getInt());
            System.out.println(buffer.getInt());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
