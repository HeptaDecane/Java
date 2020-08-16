import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock queue;

    public Producer(List<String> buffer,String color,ReentrantLock queue){
        this.buffer = buffer;
        this.color = color;
        this.queue = queue;
    }

    @Override
    public void run() {
        String[] products = {"Alpha","Beta","Gamma","Delta","Epsilon","Zeta"};
        for(String product:products){
            System.out.println(color+"Adding "+product);
            try {
                queue.lock();
                buffer.add(product);
                queue.unlock();
                Thread.sleep(new Random().nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Adding EOF");
        queue.lock();
        buffer.add("EOF");
        queue.unlock();
    }
}