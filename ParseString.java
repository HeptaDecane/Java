import java.util.Scanner;

public class Main{
	public static  Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter Number: ");
		String str = input.nextLine();

		int i = Integer.parseInt(str);
		double  d = Double.parseDouble(str);

		System.out.println("Integer: " + i);
		System.out.println("Double: " + d);
	}
}