import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private List<String> buffer;
    private String color;

    public Producer(List<String> buffer,String color){
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        String[] products = {"Alpha","Beta","Gamma","Delta","Epsilon","Zeta"};
        for(String product:products){
            System.out.println(color+"Adding "+product);
            try {
                synchronized (buffer) {
                    buffer.add(product);
                }
                Thread.sleep(new Random().nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Adding EOF");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}