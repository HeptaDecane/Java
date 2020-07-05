import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int count=0,num,sum=0;
		while(count < 10){
			System.out.print("Enter Number #" + (count+1) +": ");
			if(input.hasNextInt()){
				num = input.nextInt();
				sum+=num;
				count++;
			}
			else{
				input.nextLine();	// scan invalid Entry
				System.out.println("INVALID NUMBER ENTERED!");
			}

		}
		System.out.println("Sum = " + sum);
	}
}