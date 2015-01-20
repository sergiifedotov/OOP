package OOP.homework6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Пользователь водит имя файла, заполненого строками и вводит 
 * с клавиатуры слово. Написать метод, выполняющий поиск слова в файле 
 * и выводящий на экран индекс первого символа найденной строки, либо -1 
 * 
 * public static int find(String fileName)
 *
 */

public class FileFinder {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String fileName = "";
		while (!scan.hasNextLine()) {
			System.out.print("Имя файла: ");
			fileName = scan.nextLine();
		}
	
		System.out.println(find(fileName));
	}

	public static int find(String fileName)
			throws IOException {
		Scanner scan = new Scanner(System.in);
		String wordToFind = "";
		while (!scan.hasNextLine()) {
			System.out.print("Строка для поиска: ");
			wordToFind = scan.nextLine();
		}

		FileReader fr = new FileReader(fileName);
		Scanner scanFile = new Scanner(fr);
		int result = -1;
		while (scanFile.hasNextLine()) {
			String currentString = scanFile.nextLine();
			result = currentString.indexOf(wordToFind);
			if (result != -1) {
				break;
			}
		}

		scanFile.close();
		return result;
	}
}