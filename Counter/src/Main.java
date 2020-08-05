public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        CounterThread c1 = new CounterThread(counter);
        c1.setName("Counter 1");
        CounterThread c2 = new CounterThread(counter);
        c2.setName("Counter 2");

        c1.start();
        c2.start();
    }
}
