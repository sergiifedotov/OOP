package session1;

import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by vladimir on 11.01.15.
 * Написать класс сканера, у которого будет метод getConsoleVar
 * Если введено целое число, вернуть int, если дробное, то double
 * 
 * как вариант можно сделать с перегрузкой методов (разные параметры)
 */

public class MyScanner {
	public Scanner scan;

	public MyScanner() {
	}

	public MyScanner(Scanner scanner) {
		this();
		this.scan = scanner;
	}

	public Object next() {

		if (scan.hasNextInt()) {
			return new Integer(0);
		}

		if (scan.hasNextDouble()) {
			return new Double(0);
		}

		return scan.next().charAt(0);
	}

	public static void main(String[] args) {
		MyScanner myscan = new MyScanner(new Scanner(new StringReader(
				String.format("333"))));
		System.out.println(myscan.next().getClass());
		
		myscan.scan = new Scanner(new StringReader(String.format("qqq")));
		System.out.println(myscan.next().getClass());
		
		myscan.scan = new Scanner(new StringReader(String.format("1,1")));
		System.out.println(myscan.next().getClass());
		
	}

}
