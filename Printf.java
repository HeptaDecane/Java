/*
	https://www.hackerrank.com/challenges/java-output-formatting
*/

import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("================================");
		for (int i=0;i<3;i++){
			String str = input.next();
			int num = input.nextInt();
			System.out.printf("%-15s%03d\n",str,num);
		}
		System.out.println("================================");
	}
}