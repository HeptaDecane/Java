import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        Producer producer = new Producer(buffer,"\u001B[33m");
        Consumer consumer1 = new Consumer(buffer,"\u001B[34m");
        Consumer consumer2 = new Consumer(buffer,"\u001B[35m");

        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(producer).start();

    }
}
