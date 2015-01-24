package OOP.lesson1;

// Task1. Ввести с консоли строку с символами и пробелами. 
// Посчитать количество слов в предлождении.

import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите предложение");
		String str = scan.nextLine();
		Scanner scan1 = new Scanner(str);
		int countWords = 0;
		while (scan1.hasNext()) {
			countWords++;
			scan1.next();
		}
		System.out.println("Количество слов:" + countWords);
	}
}
