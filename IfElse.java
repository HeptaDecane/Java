/*
	https://www.hackerrank.com/challenges/java-if-else
*/

import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int n = input.nextInt();
		if(n%2==1)
			System.out.print("Weird");
		else
			if(n>=6 && n<=20)
				System.out.print("Weird");
			else
				System.out.print("Not Weird");
	}
}

