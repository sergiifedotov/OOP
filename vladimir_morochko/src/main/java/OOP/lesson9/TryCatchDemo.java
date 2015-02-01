package OOP.lesson9;

import java.util.Scanner;

/** 
 * Написать метод, принимающий с консоли строку и определяющий, 
 * представляет ли она из себя число, или нет. Если введено не число, 
 * запрашивать повторно. 
 * 
 * Вывести на экран количество неудачных попыток ввода. 
 */

public class TryCatchDemo {
	public static void main(String[] args) {
		int number = 0;
		int failedTries = 0;
		boolean intReceived = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");

		while (!intReceived) {
			intReceived = true;		
			try {
				number = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				failedTries++;
				intReceived = false;
			}
		} 
		
		System.out.println("Number: " + number + " Failed Tries: " + failedTries);
	}
}
