public class ThreadB extends Thread {
    private Object object1;
    private Object object2;

    public ThreadB(Object object1,Object object2){
        this.object1 = object1;
        this.object2 = object2;
    }

    public void run(){
        System.out.println("ThreadB waiting for object2 lock");
        synchronized (object2){
            System.out.println("ThreadB has object2 lock");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("\tThreadB waiting for object1 lock");
            synchronized (object1){
                System.out.println("\tThreadB has object1 lock");
            }
            System.out.println("\tThreadB released object1 lock");
        }
        System.out.println("ThreadB released object2 lock");
    }
}
