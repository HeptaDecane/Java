import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("listening to port:5000");
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket+" connected.");
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            byte[] bytes = new byte[64*1024];
            int n = dataInputStream.read(bytes,0,bytes.length);
            FileOutputStream fileOutputStream = new FileOutputStream("demo.pdf");
            fileOutputStream.write(bytes,0,n);
            System.out.println(n);
            fileOutputStream.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
