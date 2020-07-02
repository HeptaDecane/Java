import java.util.Scanner;

public class Main{
	public static final String INVALID_MESSAGE = "Invalid Value!";
	public static  Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter Time (Min Sec): ");
		int min = input.nextInt();
		int sec = input.nextInt();

		if(min==0)
			System.out.println(convertHMS(sec));
		else
			System.out.println(convertHMS(min,sec));
	}

	public static String convertHMS(int sec){
		int m=0,s=0;
		if(sec<0)
			return INVALID_MESSAGE;
		
		s=sec%60; m=sec/60;

		return convertHMS(m,s);
	}

	public static String convertHMS(int min,int sec){
		int h=0,m=0,s=0;
		if(min<0 || sec<0)
			return INVALID_MESSAGE;

		s=sec%60; min+=sec/60; m=min%60; h=min/60;

		return h+"h " + m+"m " + s+"s ";
	}

}