import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JPasswordField password;
    private JLabel lblNewLabel;
    private JLabel lblPassword;
    private JFormattedTextField username;
    private JButton signUp;
    private JButton signIn;
    private JLabel message;

    /**
     * Create the panel.
     */
    public LoginPanel() {
        setForeground(Color.YELLOW);
        setLayout(null);
        initializeComponents();
        addActionListeners();
    }

    public void initializeComponents(){
        lblNewLabel = new JLabel("Username: ");
        lblNewLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblNewLabel.setBounds(12, 12, 113, 37);
        add(lblNewLabel);

        lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblPassword.setBounds(12, 93, 113, 37);
        add(lblPassword);

        username = new JFormattedTextField();
        username.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        username.setBounds(12, 44, 300, 37);
        add(username);

        password = new JPasswordField();
        password.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        password.setBounds(12, 130, 300, 37);
        add(password);

        signIn = new JButton("Sign In");
        signIn.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        signIn.setBounds(100, 179, 113, 37);
        add(signIn);

        signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        signUp.setBounds(100, 440, 113, 37);
        add(signUp);

        message = new JLabel("Message");
        message.setForeground(Color.LIGHT_GRAY);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        message.setBounds(12, 248, 300, 37);
        add(message);
    }

    public void addActionListeners(){
        signUp.addActionListener(e -> {
            Main.frame.setTitle("Register");
            Main.frame.getContentPane().removeAll();
            Main.frame.setContentPane(new RegisterPanel());
            Main.frame.setVisible(true);
        });
    }
}
