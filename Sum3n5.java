import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int sum=0,count=0;
		for(int i=1;i<=1000;i++){
			if(i%15==0){	// 3x5=15
				count++;
				sum+=i;
				System.out.println("Number = "+i);
			}
			if(count>=5)
				break;
		}
		System.out.println("Sum = "+sum);
	}
}