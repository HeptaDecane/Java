public class Main {
    public static void main(String[] args) {
        System.out.println("Executing Main Thread");
        Thread task1 = new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    System.out.println(e);
                    return;
                }
                System.out.println("task1 thread awake");
            }
        };

        Thread task2 = new Thread(){
            @Override
            public void run() {
                try{
                    System.out.println("Waiting for task1 to end");
                    task1.join();
                    System.out.println("task1 ended or timed out");
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        };
        task1.start();
        task2.start();
    }
}


/*
 __________
|\        | \
| \       |  \
|  \      |   \
|   \_____|____\
|___|_____|    |
\   |      \   |
 \  |       \  |
  \ |        \ |
   \|_________\|
 */