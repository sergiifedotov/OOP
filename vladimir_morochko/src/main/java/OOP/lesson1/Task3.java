package OOP.lesson1;

import java.util.Scanner;

//Task3. Написать метод, принимающий в качестве параметра строку. 
//Возвращающий перевернутую строку, не использующий дополнительной строки.

public class Task3 {
	public static String revertString(String s) {
		char[] tempArray = new char[s.length()];
		tempArray = s.toCharArray();
		for (int i = 0; i < tempArray.length / 2; i++) {
			char tempChar = tempArray[i];
			tempArray[i] = tempArray[tempArray.length - i - 1];
			tempArray[tempArray.length - i - 1] = tempChar;
		}
		s = "";
		// s = tempArray.toString();
		for (int i = 0; i < tempArray.length; i++) {
			s += tempArray[i];
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите предложение:");
		String str = scan.nextLine();
		// String str = "abcdefg";
		System.out.println(str);
		System.out.println(revertString(str));
	}

}
