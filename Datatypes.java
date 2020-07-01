/*
	https://www.hackerrank.com/challenges/java-datatypes
*/

import java.util.*;
import java.io.*;

class Solution{
	public static Scanner input = new Scanner(System.in);
    public static void main(String []argh){
        int t=input.nextInt();

        for(int i=0;i<t;i++){

            try{
                long x=input.nextLong();
                System.out.println(x+" can be fitted in:");
// Start Code
                // -128 .. 127
                if(x>=Byte.MIN_VALUE && x<=Byte.MAX_VALUE)
                	System.out.println("* byte");

                // -32,768 .. 32767
                if(x>=Short.MIN_VALUE && x<=Short.MAX_VALUE)
                	System.out.println("* short");

                // -2,147,483,648 .. 2,147,483,647
                if(x>=Integer.MIN_VALUE && x<=Integer.MAX_VALUE)
                	System.out.println("* int");

                // -9,223,372,036,854,775,808 .. 9,223,372,036,854,775,807
                if(x>=Long.MIN_VALUE && x<=Long.MAX_VALUE)
                	System.out.println("* long");
// End Code
            }
            catch(Exception e){
                System.out.println(input.next()+" can't be fitted anywhere.");
            }

        }
    }
}