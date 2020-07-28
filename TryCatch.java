/*
	https://www.hackerrank.com/challenges/java-exception-handling-try-catch
*/

import java.util.*;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int x,y;
		try{
			x = input.nextInt();
			y = input.nextInt();
			System.out.println(x/y);
		}catch(InputMismatchException e){
			System.out.println(e.getClass().getName());
		}catch(ArithmeticException e){
			System.out.println(e);
		}
	}
}	