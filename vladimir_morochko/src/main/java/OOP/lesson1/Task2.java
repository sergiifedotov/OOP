package OOP.lesson1;

import java.util.Scanner;

// Task2. Написать метод, принимающий в качестве параметра строку. 
// Возвращающий перевернутую строку.

public class Task2 {
	public static String revertString(String s) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++)
			s1 += s.charAt(s.length() - i - 1);
		return s1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите предложение:");
		String str = scan.nextLine();
		// String s = "abcdefg";
		// System.out.println(str);
		System.out.println(revertString(str));
	}
}
