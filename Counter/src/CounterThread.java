public class CounterThread extends Thread{
    Counter counter;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.countdown();
    }
}
