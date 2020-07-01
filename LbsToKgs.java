import java.util.*;

public class Main{
	public static void main(String[] args) {
		System.out.print("Enter Weight in Pounds: ");
		Scanner input = new Scanner(System.in);
		double lbs = input.nextDouble();
		double kgs = lbs*0.45359237;
		System.out.println("Weight in KGs = "+kgs);
	}
}