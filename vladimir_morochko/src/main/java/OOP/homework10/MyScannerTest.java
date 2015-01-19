package OOP.homework10;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class MyScannerTest {
	public static void main(String[] args) throws IOException {
		String myString = null;
		int myInt = 0;
		Reader read = new StringReader(String.format("jkl 333 sdf fgh"));
		MyScanner scan = new MyScanner(read);
		
		myString = scan.next();
		System.out.println(myString);
		
		myInt = scan.nextInt();
		System.out.println(myInt);
		
		myString = scan.nextLine();
		System.out.println(myString);

		
		for (int i = 0; i < myString.length(); i++) {
			System.out.print((int)myString.charAt(i) + " ");
		}
		
		scan.close();
	}

}
