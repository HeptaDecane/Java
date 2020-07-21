import xyz.example.heptadecane.Series;

public class Main {

    public static void main(String[] args) {
        System.out.printf("%-15s%-15s%s\n","Fibonacci","Sum","Factorial");
        for(int i=0;i<10;i++)
            System.out.printf("%-15d%-15d%d\n",Series.fibonacci(i),Series.nSum(i),Series.factorial(i));
    }
}
