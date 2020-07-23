/*
	https://www.hackerrank.com/challenges/phone-book
*/

import java.util.*;

public class Main{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = input.nextInt();
		input.nextLine();
		Map<String,Integer> contacts = new HashMap<>();
		for(int i=0;i<n;i++){
			String name = input.nextLine();
			int phone = input.nextInt();
			input.nextLine();
			contacts.put(name,phone);
		}

		String query;
		while(input.hasNext()){
			query = input.nextLine();
			if(contacts.get(query) == null)
				System.out.println("Not found");
			else
				System.out.println(query+"="+contacts.get(query));
		}
	}
}	