import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private final JTextField textField;
    private final JButton button;
    private final JTextPane textPane;
    private final JLabel label;
    /**
     * Create the panel.
     */
    public Panel() {
        setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        textField.setBounds(12, 39, 235, 47);
        add(textField);
        textField.setColumns(10);

        button = new JButton("GO");
        button.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
        button.setBounds(259, 38, 55, 47);
        add(button);

        textPane = new JTextPane();
        textPane.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        textPane.setEditable(false);
        textPane.setContentType("Hello");
        textPane.setBounds(12, 98, 301, 174);
        add(textPane);

        label = new JLabel("Name:");
        label.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        label.setBounds(12, 12, 70, 26);
        add(label);

        button.addActionListener(e -> {
            String name = textField.getText();
            if(name.equalsIgnoreCase(""))
                name = "Unknown";
            textPane.setText("Welcome, "+name+"!");
        });
    }
}
