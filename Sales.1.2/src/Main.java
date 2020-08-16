import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock queue = new ReentrantLock();
        ExecutorService service = Executors.newFixedThreadPool(3);
        Producer producer = new Producer(buffer,"\u001B[33m",queue);
        Consumer consumer1 = new Consumer(buffer,"\u001B[34m",queue);
        Consumer consumer2 = new Consumer(buffer,"\u001B[35m",queue);

        service.execute(producer);
        service.execute(consumer1);
        service.execute(consumer2);
        service.shutdown();

    }
}
