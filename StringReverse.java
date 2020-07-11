/*
	https://www.hackerrank.com/challenges/java-string-reverse
*/

import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String str = input.next();

		StringBuilder transform = new StringBuilder();
		transform.append(str);
		transform = transform.reverse();

		String rev = transform.toString();
		if(rev.compareTo(str)==0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}