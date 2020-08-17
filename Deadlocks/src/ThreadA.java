public class ThreadA extends Thread {
    private Object object1;
    private Object object2;

    public ThreadA(Object object1,Object object2){
        this.object1 = object1;
        this.object2 = object2;
    }

    public void run(){
        System.out.println("ThreadA waiting for object1 lock");
        synchronized (object1){
            System.out.println("ThreadA has object1 lock");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("\tThreadA waiting for object2 lock");
            synchronized (object2){
                System.out.println("\tThreadA has object2 lock");
            }
            System.out.println("\tThreadA released object2 lock");
        }
        System.out.println("ThreadA released object1 lock");
    }
}
