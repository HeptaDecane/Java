public class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read(){
        while (empty){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        while (!empty) {
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        empty = false;
        notifyAll();
        this.message = message;
    }
}