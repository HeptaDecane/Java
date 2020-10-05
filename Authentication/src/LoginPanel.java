import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class LoginPanel extends JPanel {
    private JPasswordField passwordField;
    private JLabel lblNewLabel;
    private JLabel lblPassword;
    private JFormattedTextField usernameField;
    private JButton signUp;
    private JButton signIn;
    private JLabel message;

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

        usernameField = new JFormattedTextField();
        usernameField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        usernameField.setBounds(12, 44, 300, 37);
        add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        passwordField.setBounds(12, 130, 300, 37);
        add(passwordField);

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

        message = new JLabel("");
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

        signIn.addActionListener(e -> {
            if(isValidEntry().length() == 0){
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                User user = Main.authenticate(username,password);
                if(user != null){
                    Main.frame.setTitle("Home");
                    Main.frame.getContentPane().removeAll();
                    Main.frame.setContentPane(new HomePage(user));
                    Main.frame.setVisible(true);
                }
                else{
                    message.setText("Incorrect Username or Password");
                }
            }
            else {
                message.setText("Invalid:"+isValidEntry());
            }
        });
    }

    public String isValidEntry(){
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String error = "";

        if(!Pattern.matches("[a-zA-Z0-9]{4,16}",username))
            error = " Username";
        if (password.length()<8)
            error += " Password";

        return error;
    }
}
