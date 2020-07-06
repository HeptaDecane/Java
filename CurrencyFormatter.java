/*
	https://www.hackerrank.com/challenges/java-currency-formatter
*/

import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Main{
	public static Scanner input = new Scanner(System.in);
	public static Locale localeINDIA = new Locale("en","IN");

	public static void main(String[] args) {
		double money = input.nextDouble();
		
		NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat india = NumberFormat.getCurrencyInstance(localeINDIA);
		NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

		System.out.println("US: " + us.format(money));
		System.out.println("India: " + india.format(money));
		System.out.println("China: " + china.format(money));
		System.out.println("France: " + france.format(money));
	}
}