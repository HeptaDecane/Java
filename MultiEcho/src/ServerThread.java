import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket clientSocket;

    public ServerThread(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println(clientSocket+" connected.");
            BufferedReader iStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter oStream = new PrintWriter(clientSocket.getOutputStream(),true);

            while (true){
                String message = iStream.readLine();
                System.out.println(clientSocket.getPort()+": "+message);
                if(message.equalsIgnoreCase("exit")){
                    oStream.println("connection closed.");
                    System.out.println("connection closed.");
                    break;
                }
            }

        }catch (IOException e){
            System.out.println(e);
        }finally {
            try {
                clientSocket.close();
            }catch (IOException e){ }
        }
    }
}
