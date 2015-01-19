package OOP.lesson9;

import java.io.*;

/**
 * Дан текстовый файл, прочитать его и вывести на экран. 
 * В задании не использовать сканер. 
 */

public class FileRead {
	public static void main(String[] args) {
		FileReader fr = null;
		// если объявить ридер внутри try-catch, то его не будет видно снаружи
		try {
			fr = new FileReader("file1.txt");
			int receive;
			while ((receive = fr.read()) != -1) {
				System.out.print((char) receive);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) { 
					// если файл не был открыт, т.е. ошибка в 
					// конструкторе, то при попытке закрыть null программа обрушится
					fr.close();
				}
			} catch (IOException e) {} // на случай если файл не закроется
		}
	}

}
