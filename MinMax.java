import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int num;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while(true){
			System.out.print("Enter Number [-1:Exit]: ");
			if(input.hasNextInt()){
				num = input.nextInt();
				if(num==-1)
					break;
				if(num<min)
					min = num;
				if(num>max)
					max = num;
			}
			else{
				input.nextLine();	// scan invalid entry
				System.out.println("ERROR: INVALID NUMBER ENTERED");
			}
		}

		System.out.println("Max Entry: " + max);
		System.out.println("Min Entry: " + min);
	}
}