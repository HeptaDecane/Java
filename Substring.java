/*
	https://www.hackerrank.com/challenges/java-substring
*/

import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String str = input.next();
		int start = input.nextInt();
		int end = input.nextInt();

		System.out.println(str.substring(start,end));
	}
}