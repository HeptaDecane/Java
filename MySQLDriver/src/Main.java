import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    static final String username = "31165";
    static final String password = "31165@mysql";
    static final String database = "A03";
    static final String host = "localhost";
    static final String port = "3306";

    public static void main(String[] args) {
        String url = "jdbc:mysql://"+host+":"+port+"/"+database;
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select version();");
            System.out.println("database connected");

            while(resultSet.next())
                System.out.println("MySQL: "+resultSet.getString(1));

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}