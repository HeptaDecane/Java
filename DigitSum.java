import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter Number: ");
		int n = input.nextInt();
		System.out.println("Digit Sum = " + digitSum(n));
	}

	public static int digitSum(int n){
		if(n<0)
			return -1;
		int sum = 0;
		while(n!=0){
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
}