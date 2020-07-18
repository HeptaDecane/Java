/*
	https://www.hackerrank.com/challenges/java-list
*/

import java.util.Scanner;
import java.util.List;
import java.util.Vector;


public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		List<Integer> list = new Vector<>();
		for(int i=0;i<n;i++)
			list.add(input.nextInt());

		int q = input.nextInt();
		String query;
		int x,y;

		for(int i=0;i<q;i++){
			query = input.next().toLowerCase();
			if(query.equals("insert")){
				x = input.nextInt();
				y = input.nextInt();
				list.add(x,y);
			}
			else if(query.equals("delete")){
				x = input.nextInt();
				list.remove(x);
			}
		}

		for(int element : list)
			System.out.print(element+" ");
	}
}