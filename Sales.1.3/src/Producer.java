import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public Producer(ArrayBlockingQueue<String> buffer,String color){
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        String[] products = {"Alpha","Beta","Gamma","Delta","Epsilon","Zeta"};
        for(String product:products){
            try {
                System.out.println(color+"Adding "+product);
                buffer.put(product);
                Thread.sleep(new Random().nextInt(1000));
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Adding EOF");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}