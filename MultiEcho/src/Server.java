import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("listening to port:5000");
            ExecutorService service = Executors.newCachedThreadPool();
            while (true){
                Socket clientSocket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(clientSocket);
                service.execute(serverThread);
            }
        } catch (Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }
}
