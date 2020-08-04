import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {

    }

    private static void printFile(Path path){
        try(Scanner scanner = new Scanner(Files.newBufferedReader(path))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
