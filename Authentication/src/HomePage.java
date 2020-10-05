import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private JLabel label;
    private JButton logout;
    private JTextPane textPane;

    public HomePage(User user) {
        setLayout(null);
        initializeComponents(user);
        addActionListener();
    }

    public void initializeComponents(User user){
        label = new JLabel("Greeting...");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        label.setBounds(23, 25, 268, 35);
        add(label);

        logout = new JButton("Logout");
        logout.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        logout.setBounds(103, 240, 117, 35);
        add(logout);

        textPane = new JTextPane();
        textPane.setBounds(33, 71, 258, 80);
        add(textPane);

        if(user != null){
            label.setText("Welcome! "+user.getUsername());
            textPane.setText(user.getName());
        }
    }

    public void addActionListener(){
        logout.addActionListener(e -> {
            Main.frame.setTitle("Login");
            Main.frame.getContentPane().removeAll();
            Main.frame.setContentPane(new LoginPanel());
            Main.frame.setVisible(true);
        });
    }
}