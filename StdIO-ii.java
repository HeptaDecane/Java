/*
	https://www.hackerrank.com/challenges/java-stdin-stdout
*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int i = input.nextInt();
		double d = input.nextDouble();
		input.nextLine();	// clear newline
		String s = input.nextLine();

		System.out.println("String: "+s);
		System.out.println("Double: "+d);
		System.out.println("Int: "+i);
	}
}
