import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(7);
        ExecutorService service = Executors.newFixedThreadPool(3);
        Producer producer = new Producer(buffer,"\u001B[33m");
        Consumer consumer1 = new Consumer(buffer,"\u001B[34m");
        Consumer consumer2 = new Consumer(buffer,"\u001B[35m");

        service.execute(producer);
        service.execute(consumer1);
        service.execute(consumer2);
        service.shutdown();

    }
}
