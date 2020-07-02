import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter 1st Number: ");
		int n1 = input.nextInt();
		System.out.print("Enter 2nd Number: ");
		int n2 = input.nextInt();

		int min = minimum(n1,n2);
		System.out.println("Minimum: "+min);
	}
	public static int minimum(int n1,int n2){
		int min = n1<n2 ? n1 : n2;
		return(min); 
	}
}