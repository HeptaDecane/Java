import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock queue = new ReentrantLock();
        Producer producer = new Producer(buffer,"\u001B[33m",queue);
        Consumer consumer1 = new Consumer(buffer,"\u001B[34m",queue);
        Consumer consumer2 = new Consumer(buffer,"\u001B[35m",queue);

        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(producer).start();

    }
}
