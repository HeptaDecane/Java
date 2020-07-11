/*
	https://www.hackerrank.com/challenges/java-arraylist
*/

import java.util.*;	

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		ArrayList<Integer>[] lists = new ArrayList[n];

		for(int i=0;i<n;i++)
			lists[i] = new ArrayList<Integer>();

		for(int i=0;i<n;i++){
			int m = input.nextInt();
			for(int j=0;j<m;j++){
				int a = input.nextInt();
				lists[i].add(a);
			}
		}

		int q = input.nextInt();
		int x,y;

		for(int i=0;i<q;i++){
			x = input.nextInt();
			y = input.nextInt();
			x--;y--;

			if(x<n){
				if(y<lists[x].size())
					System.out.println(lists[x].get(y));
				else
					System.out.println("ERROR!");
			}
			else
				System.out.println("ERROR!");
		}
	}
}