import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String name;

    public User(String username,String password,String name){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

}
