/*
    Text Files
 */
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main0 {
    public static void main(String[] args) {
        try{
            Path logins = FileSystems.getDefault().getPath("logins.txt");
            Path loginsFormatted = FileSystems.getDefault().getPath("logins_Formatted.txt");
            Files.write(loginsFormatted,"".getBytes(),StandardOpenOption.TRUNCATE_EXISTING);

            List<String> lines = Files.readAllLines(logins);
            for(String line:lines){
                String[] parts = line.split(":");
                System.out.printf("%-50s%s\n",parts[0],parts[1]);
                Files.write(loginsFormatted,("Email: "+parts[0]+"\n").getBytes(),StandardOpenOption.APPEND);
                Files.write(loginsFormatted,("Password: "+parts[1]+"\n\n").getBytes(),StandardOpenOption.APPEND);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
