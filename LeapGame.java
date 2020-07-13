/*
	https://www.hackerrank.com/challenges/java-1d-array
*/

import java.util.*;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int q = input.nextInt();
		while(q>0){
			leapGame();	
			q--;
		}
	}

	public static void leapGame(){
		int n = input.nextInt();
		int leap = input.nextInt();
		int[] game = new int[n];

		for(int i=0;i<n;i++)
			game[i] = input.nextInt();

		if(solved(game,leap,0))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static boolean solved(int[] game,int leap,int pos){
		if(pos >= game.length)
			return true;
		else if(pos<0)
			return false;
		else if(game[pos]==1)
			return false;
		game[pos] = 1;

		return (
					solved(game,leap,pos+leap) ||
				 	solved(game,leap,pos+1) ||
				 	solved(game,leap,pos-1)
				);
	}
}