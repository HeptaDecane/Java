/*
	https://www.hackerrank.com/challenges/java-2d-array
*/

import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] grid = new int[6][6];
		for(int i=0;i<6;i++)
			for(int j=0;j<6;j++)
				grid[i][j] = input.nextInt();

		int max = -100;
		int sum;
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				sum = 0;
				sum += grid[i][j]+grid[i][j+1]+grid[i][j+2];
				sum += grid[i+1][j+1];
				sum += grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];

				if(sum>max)
				 	max = sum;
			}
		}
		System.out.println(max);
	}
}	