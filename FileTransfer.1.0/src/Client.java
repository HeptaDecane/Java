import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",5000)) {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            byte[] bytes = new byte[64*1024];
            FileInputStream fileInputStream = new FileInputStream("/path/to/file.pdf");
            int n = fileInputStream.read(bytes,0,bytes.length);
            dataOutputStream.write(bytes,0,n);
            System.out.println(n);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
