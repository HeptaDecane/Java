import java.util.Scanner;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter Day Number: ");
		int dayNumber = input.nextInt();
		System.out.println(dayOfTheWeek(dayNumber));
	}

	public static String dayOfTheWeek(int dayNumber){
		String day;
		switch(dayNumber){
			case 1:
				day = "SUNDAY";
				break;
			case 2:
				day = "MONDAY";
				break;
			case 3:
				day = "TUESDAY";
				break;
			case 4:
				day = "WEDNESDAY";
				break;
			case 5:
				day = "THURSDAY";
				break;
			case 6:
				day = "FRIDAY";
				break;
			case 7:
				day = "SATURDAY";
				break;
			default:
				day= "ERROR: INVALID DAY NUMBER";
		}
		return day;
	}
}