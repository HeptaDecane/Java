import java.util.Scanner;

public class Solution {
// Start Code

/*
	https://www.hackerrank.com/challenges/java-anagrams
*/  

    static boolean isAnagram(String a, String b) {
    	int lengthA = a.length();
        int lengthB = b.length();

        if(lengthA != lengthB)
        	return false;
 
        char[] arrayA = a.toLowerCase().toCharArray();
        char[] arrayB = b.toLowerCase().toCharArray();
        

        arrayA = sort(arrayA,lengthA);
        arrayB = sort(arrayB,lengthB);

        for(int i=0;i<lengthA;i++){
        	if(arrayA[i] != arrayB[i])
        		return false;
        }
        return true;
        
    }

    public static char[] sort(char[] arr,int length){
    	char temp;
    	for(int i=0;i<length;i++){
    		for(int j=i;j<length;j++){
    			if(arr[i]>arr[j]){
    				temp = arr[i];
    				arr[i] = arr[j];
    				arr[j] = temp;
    			}
    		}
    	}
    	return arr;
    }

// End Code
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}