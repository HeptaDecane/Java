import java.util.*;

public class Solution {

    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
// Start Code
/*
    https://www.hackerrank.com/challenges/java-1d-array-introduction
*/
    int[] a = new int[n];
    for(int i=0;i<n;i++)
        a[i] = scan.nextInt();

// End Code
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}