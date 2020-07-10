/*
	https://www.hackerrank.com/challenges/java-strings-introduction
*/

import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String str1 = input.next();
		String str2 = input.next();

		int letters = str1.length()+str2.length();
		int flag = str1.compareTo(str2);
		String str = str1.substring(0,1).toUpperCase()+str1.substring(1) 
		             + " " + str2.substring(0,1).toUpperCase()+str2.substring(1);

		System.out.println(letters);
		if(flag>0)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println(str);
	}
}