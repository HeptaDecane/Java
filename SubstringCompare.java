import java.util.Scanner;

public class Solution {
//Start Code

/*
	https://www.hackerrank.com/challenges/java-string-compare
*/

    public static String getSmallestAndLargest(String str, int k) {
        int n = str.length()-k+1;
        String[] subs = new String[n];
            for(int i=0;i<n;i++)
                subs[i] = str.substring(i,i+k);

            String temp;
            String smallest = subs[0];
            String largest = subs[0];
            for(int i=0;i<n;i++){
                if(subs[i].compareTo(smallest)<0)
                	smallest = subs[i];

               	if(subs[i].compareTo(largest)>0)
               		largest = subs[i];
            }
        return smallest + "\n" + largest;
    }

// End Code
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}