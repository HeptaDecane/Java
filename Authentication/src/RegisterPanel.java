import javax.swing.*;
import java.awt.*;


public class RegisterPanel extends JPanel {
    private JPasswordField password;
    private JPasswordField password1;
    private JLabel lblNewLabel;
    private JLabel lblPassword;
    private JFormattedTextField username;
    private JButton signUp;
    private JButton signIn;
    private JLabel message;
    private JLabel lblName;
    private JFormattedTextField firstName;
    private JLabel lblLastName;
    private JLabel lblConfirmPassword;
    private JFormattedTextField lastName;

    /**
     * Create the panel.
     */
    public RegisterPanel() {
        setForeground(Color.YELLOW);
        setLayout(null);
        initializeComponents();
        addActionListeners();
    }

    public void initializeComponents(){
        lblNewLabel = new JLabel("Username: ");
        lblNewLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblNewLabel.setBounds(12, 0, 113, 37);
        add(lblNewLabel);

        lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblPassword.setBounds(12, 194, 113, 37);
        add(lblPassword);

        username = new JFormattedTextField();
        username.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        username.setBounds(12, 30, 300, 37);
        add(username);

        password = new JPasswordField();
        password.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        password.setBounds(12, 225, 300, 37);
        add(password);

        signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        signUp.setBounds(95, 391, 113, 37);
        add(signUp);

        signIn = new JButton("Sign In");
        signIn.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        signIn.setBounds(95, 440, 113, 37);
        add(signIn);

        message = new JLabel("Message");
        message.setForeground(Color.LIGHT_GRAY);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        message.setBounds(12, 342, 300, 37);
        add(message);

        lblName = new JLabel("First Name:");
        lblName.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblName.setBounds(12, 63, 113, 37);
        add(lblName);

        firstName = new JFormattedTextField();
        firstName.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        firstName.setBounds(12, 94, 300, 37);
        add(firstName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblLastName.setBounds(12, 128, 113, 37);
        add(lblLastName);

        lblConfirmPassword = new JLabel("Confirm Password: ");
        lblConfirmPassword.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblConfirmPassword.setBounds(12, 262, 196, 37);
        add(lblConfirmPassword);

        password1 = new JPasswordField();
        password1.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        password1.setBounds(12, 293, 300, 37);
        add(password1);

        lastName = new JFormattedTextField();
        lastName.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        lastName.setBounds(12, 158, 300, 37);
        add(lastName);
    }

    public void addActionListeners(){
        signIn.addActionListener(e -> {
            Main.frame.setTitle("Login");
            Main.frame.getContentPane().removeAll();
            Main.frame.setContentPane(new LoginPanel());
            Main.frame.setVisible(true);
        });
    }

}
