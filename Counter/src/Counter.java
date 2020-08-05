/*
    Note:
        # local variables stored in separate thread stacks for each thread.
        # instances and data members are stored in heap and shared by threads.
 */

public class Counter {
    private int i;      // data member

    public void countdown(){
        String color;
        switch (Thread.currentThread().getName()){
            case "Counter 1":
                color = "\u001B[31m";
                break;
            case "Counter 2":
                color = "\u001B[33m";
                break;
            default:
                color = "\u001B[37m";
        }

        int j=0;    // local variable
        for(i=10;i>0;i--) {
            j++;
            System.out.println(color + j + ". " + Thread.currentThread().getName() + " : i = " + i);
        }
    }
}
