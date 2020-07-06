/*
	https://www.hackerrank.com/challenges/java-loops-i/problem
*/
import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		for(int i=1; i<=10; i++)
			System.out.println(n + " x " + i + " = " + n*i);
	}
}