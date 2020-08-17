public class Main {
    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public static void main(String[] args) {
        new ThreadA(object1,object2).start();
        new ThreadB(object1,object2).start();
    }
}
