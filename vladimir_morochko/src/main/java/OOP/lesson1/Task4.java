package OOP.lesson1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Task5. 
//1) Написать метод, который в качестве параметра принимает имя файла.
//Метод возвращает двухмерный массив (String): имена переменных и значение.
//
//В файле набор переменных указаны так:
//v=[156],ghg,hg;m=[12],tytuyr894848;vector=[qwe]; 
//Переменных не больше 10
//
//2) Метод принимает этот массив, в качестве параметров и выводит на экран.
//
//3) В мейне:
//- создать массив, 
//-считать с консоли имя файла, 
//- передать его в метод1
//- полученный массив передать в метод 2

public class Task4 {
	public static void main(String[] args) throws IOException {
		// Scanner scan = new Scanner(System.in);
		// System.out.print("Имя файла: ");
		// String fileName = scan.next();
		String fileName = "file1.txt";
		String[][] strArray = new String[10][2];
		readFile(fileName, strArray);
		printArray(strArray);
	}

	private static void printArray(String[][] strArray) throws IOException {
		for (int i = 0; i < strArray.length; i++) {
			System.out.print(strArray[i][0]);
			System.out.print(" = ");
			System.out.println(strArray[i][1]);
		}
	}

	private static void readFile(String fileName, String[][] inArray)
			throws IOException {
		FileReader fr = new FileReader(fileName);
		Scanner scanFile = new Scanner(fr);
		String currentString = "";
		while (scanFile.hasNextLine()) { // пока файл не закончится
			currentString = scanFile.nextLine(); // берем длинную строку из
													// файла
			// и разбиваем на кусочки по точкам с запятой
			ArrayList<Integer> parsingList = new ArrayList<Integer>();
			parsingList.add(0); // начинаем сначала, первый элемент 0
			for (int i = 0; i < currentString.length(); i++) {
				if (currentString.charAt(i) == ';') {
					parsingList.add(i);
				}
			}
			// каждый кусочек содержит имя переменной, значение и мусор
			for (int i = 0; i < parsingList.size() - 1; i++) {
				// для каждого кусочка
				String singleString = currentString.substring(
						parsingList.get(i), parsingList.get(i + 1));
				// берем имя переменной
				int startPosition = 0;
				if (singleString.charAt(startPosition) == ';') {
					startPosition++;
				}
				int endPosition = singleString.indexOf("=[");
				inArray[i][0] = singleString.substring(startPosition,
						endPosition);
				// берем ее значение
				startPosition = endPosition + 2;
				endPosition = singleString.indexOf("]");
				inArray[i][1] = singleString.substring(startPosition,
						endPosition);
			}
		}
		scanFile.close();
	}

}
