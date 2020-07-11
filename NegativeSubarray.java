/*
	https://www.hackerrank.com/challenges/java-negative-subarray
*/

import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++)
			array[i] = input.nextInt();

		int sum,count=0;
		for(int i=0;i<n;i++){
			sum = 0;
			for(int j=i;j<n;j++){
				sum += array[j];
				if(sum<0)
					count++;
			}
		} 
		System.out.println(count);
	}
}