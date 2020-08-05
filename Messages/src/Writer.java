import java.util.Random;

public class Writer implements Runnable {
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        };

        Random random = new Random();
        for(String each:messages){
            message.write(each);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        message.write("#END");
    }
}
