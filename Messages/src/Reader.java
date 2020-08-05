import java.util.Random;

public class Reader implements Runnable {
    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        String newMessage = message.read();
        while(!newMessage.equals("#END")){
            System.out.println(newMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e);
            }
            newMessage = message.read();
        }
    }
}
