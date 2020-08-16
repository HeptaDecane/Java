import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock queue;

    public Consumer(List<String> buffer, String color,ReentrantLock queue){
        this.buffer = buffer;
        this.color = color;
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){
            queue.lock();
            if (buffer.isEmpty()) {
                queue.unlock();
                continue;
            }
            if (buffer.get(0).equals("EOF")) {
                System.out.println(color + "Exiting...");
                queue.unlock();
                break;
            } else
                System.out.println(color + "Removed " + buffer.remove(0));
            queue.unlock();
        }
    }

}
