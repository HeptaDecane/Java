public class Main {
    public static void main(String[] args) {
        System.out.println("Executing Main Thread");
        new Thread(){
            @Override
            public void run() {
                System.out.println("Executing New Thread");
            }
        }.start();
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