import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;


public class RegisterPanel extends JPanel {
    private JPasswordField passwordField;
    private JPasswordField passwordField1;
    private JLabel lblNewLabel;
    private JLabel lblPassword;
    private JFormattedTextField usernameField;
    private JButton signUp;
    private JButton signIn;
    private JLabel message;
    private JLabel lblName;
    private JFormattedTextField firstNameField;
    private JLabel lblLastName;
    private JLabel lblConfirmPassword;
    private JFormattedTextField lastNameField;

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

        usernameField = new JFormattedTextField();
        usernameField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        usernameField.setBounds(12, 30, 300, 37);
        add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        passwordField.setBounds(12, 225, 300, 37);
        add(passwordField);

        signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        signUp.setBounds(95, 391, 113, 37);
        add(signUp);

        signIn = new JButton("Sign In");
        signIn.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        signIn.setBounds(95, 440, 113, 37);
        add(signIn);

        message = new JLabel("");
        message.setForeground(Color.LIGHT_GRAY);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        message.setBounds(12, 342, 300, 37);
        add(message);

        lblName = new JLabel("First Name:");
        lblName.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblName.setBounds(12, 63, 113, 37);
        add(lblName);

        firstNameField = new JFormattedTextField();
        firstNameField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        firstNameField.setBounds(12, 94, 300, 37);
        add(firstNameField);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblLastName.setBounds(12, 128, 113, 37);
        add(lblLastName);

        lblConfirmPassword = new JLabel("Confirm Password: ");
        lblConfirmPassword.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        lblConfirmPassword.setBounds(12, 262, 196, 37);
        add(lblConfirmPassword);

        passwordField1 = new JPasswordField();
        passwordField1.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        passwordField1.setBounds(12, 293, 300, 37);
        add(passwordField1);

        lastNameField = new JFormattedTextField();
        lastNameField.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
        lastNameField.setBounds(12, 158, 300, 37);
        add(lastNameField);
    }

    public void addActionListeners(){
        signIn.addActionListener(e -> {
            Main.frame.setTitle("Login");
            Main.frame.getContentPane().removeAll();
            Main.frame.setContentPane(new LoginPanel());
            Main.frame.setVisible(true);
        });

        signUp.addActionListener(e -> {
            String username = usernameField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String password1 = String.valueOf(passwordField1.getPassword());
            if(isValidEntry().length() == 0){
                String name = firstName+" "+lastName;
                User user = new User(username,password,name);
                if(Main.addNewUser(user)){
                    Main.saveUsers();
                    Main.frame.setTitle("Home");
                    Main.frame.getContentPane().removeAll();
                    Main.frame.setContentPane(new HomePage(user));
                    Main.frame.setVisible(true);
                }else {
                    message.setText("Username Exists");
                }
            }
            else {
                message.setText("Invalid:"+isValidEntry());
            }

        });
    }

    public String isValidEntry(){
        String username = usernameField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String password1 = String.valueOf(passwordField1.getPassword());
        String error = "";

        if(!Pattern.matches("[a-zA-Z0-9]{4,16}",username))
            error = " Username";
        if(!Pattern.matches("[a-zA-Z]+",firstName))
            error += " FirstName";
        if(!Pattern.matches("[a-zA-Z]+",lastName))
            error += " LastName";
        if (!password.equals(password1) || password.length()<8)
            error += " Password";

        return error;
    }

}
