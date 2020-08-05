public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        Writer writer = new Writer(message);
        Reader reader = new Reader(message);

        Thread write = new Thread(writer);
        write.setName("writer");
        Thread read = new Thread(reader);
        read.setName("reader");

        write.start();
        read.start();
    }
}
