import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Waiting for key strokes...");
        char key = input.next().charAt(0);

        while (key != '0') {
            char stroke = key;  //final
            // keyStroke is an object of Anonymous Class
            iButton keyStroke = new iButton() {
                char key = stroke;

                @Override
                public void onClick() {
                    System.out.println("Tapped "+this.key);
                }
            };
            keyStroke.onClick();
            key = input.next().charAt(0);
        }
    }
}
