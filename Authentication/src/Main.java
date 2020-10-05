
import javax.swing.*;
import java.awt.*;

public class Main {
    public static JFrame frame = new JFrame();

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            System.out.println("Using: CrossPlatformLookAndFeel");
        }
        Dimension dimension = new Dimension(330,536);
        frame.setLocation(750,250);
        frame.setSize(dimension);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        frame.setTitle("Login");
        frame.setContentPane(new LoginPanel());
        frame.setVisible(true);
    }
}