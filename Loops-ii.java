/*
	https://www.hackerrank.com/challenges/java-loops
*/

import java.util.Scanner;
import java.lang.Math;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int q = input.nextInt();

		while(q!= 0){
			printSequence();
			q--;
		}
	}

	public static void printSequence(){
		int a = input.nextInt();
		int b = input.nextInt();
		int n = input.nextInt();

		int sum = a;
		for(int i=0; i<n; i++){
			sum += Math.pow(2,i)*b;
			if(i==n-1)
				System.out.print(sum + "\n");
			else
				System.out.print(sum + " ");
		}
	}
}