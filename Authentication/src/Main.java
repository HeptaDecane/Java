import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

public class Main {
    public static JFrame frame = new JFrame();
    private static HashMap<String,User> users = null;
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            System.out.println("Using: CrossPlatformLookAndFeel");
        }
        users = new HashMap<>();
        Dimension dimension = new Dimension(330,536);
        frame.setLocation(750,250);
        frame.setSize(dimension);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loadUsers();
    }

    private static void loadUsers(){
        try(
            FileInputStream file = new FileInputStream("users.dat");
            BufferedInputStream buffer = new BufferedInputStream(file);
            ObjectInputStream iStream = new ObjectInputStream(buffer)
        ){
            while (true){
                User user = (User) iStream.readObject();
                users.put(user.getUsername(),user);
            }
        }catch (EOFException e){
            System.out.println("Loaded Users");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public static boolean addNewUser(User user){
        if(users.containsKey(user.getUsername()))
            return false;
        users.put(user.getUsername(),user);
        return true;
    }

    public static void saveUsers(){
        try(
            FileOutputStream file = new FileOutputStream("users.dat");
            BufferedOutputStream buffer = new BufferedOutputStream(file);
            ObjectOutputStream oStream = new ObjectOutputStream(buffer)
        ){
            for (User user : users.values())
                oStream.writeObject(user);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public static User authenticate(String username, String password){
        if(users.containsKey(username)){
            User user = users.get(username);
            if(user.matchPassword(password))
                return user;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        frame.setTitle("Login");
        frame.setContentPane(new LoginPanel());
        frame.setVisible(true);
    }
}