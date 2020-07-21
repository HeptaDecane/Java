import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
// Start Code

/*
	https://www.hackerrank.com/challenges/java-static-initializer-block
*/	

	private static final Scanner input = new Scanner(System.in);
	private static final int B;
	private static final int H;
	private static boolean flag = true;

static{
	B = input.nextInt();
	H = input.nextInt();

	try{
		if(B<=0 || H<=0){
			flag = false;
			throw new Exception("Breadth and height must be positive");
		}
	}catch(Exception e){
		System.out.println(e);
	}
}

// End Code
public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

