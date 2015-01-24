package OOP.homework10;

import java.io.*;
import java.util.InputMismatchException;


/**
 * Написать собственную реализацию класса Scanner (MyScanner), 
 * работающую с символьными потоками.
 * Создать конструктор, куда передается объект по ссылке Reader.
 * 
 * Реализовать методы:
 * 
 * String next() - чтение одного слова в строке
 * int nextInt() - чтение целого числа из строки или InputMismatchException
 * String nextLine() - чтение всей строки
 * boolean hasNext() - определение наличия в потоке данных
 * boolean hasNextInt() - определение наличия в потоке целого int числа
 * useDelimiter(char) - использует разделитель
 * close() - закрытие сканнера, теперь нельзя использовать
 * 
 * После закрытия сканнера, любой метод должен выбрасывать IllegalStateException
 * 
 * Класс задания hw6.scanner.Scanner
 * 
 */

public class MyScanner implements Closeable {
	private Reader reader;
	private char delimiter;
	private boolean myScannerActive;
	private StringBuilder buffer;
	private String currentWord;
	private final char endOfStringValue = (char) 65535;
	

	public MyScanner() {
		setDelimiter(' ');
		buffer = new StringBuilder();
	}

	public MyScanner(Reader reader) throws IOException {
		this();
		this.reader = reader;
		setMyScannerActive(true);
		getDataFromReader();
		currentWord = getNextWordFromBuffer();
	}

	public String next() throws IOException {
		checkScannerStatus();
		String answer = currentWord;
		currentWord = getNextWordFromBuffer();
		return answer;
	}

	public int nextInt() throws IOException, InputMismatchException {
		checkScannerStatus();
		int answer = 0;
		if (hasNextInt()) {
			answer = Integer.parseInt(currentWord);
			currentWord = getNextWordFromBuffer();
		} else {
			throw new InputMismatchException();
		}
		return answer;
	}

	public String nextLine() throws IOException {
		checkScannerStatus();
		String answer = currentWord + delimiter + getNextLineFromBuffer();
		currentWord = getNextWordFromBuffer();
		return answer;
	}

	public boolean hasNext() throws IOException {
		checkScannerStatus();
		return (currentWord != null && currentWord.length() != 0);
	}

	public boolean hasNextInt() throws IOException {
		checkScannerStatus();
		boolean answer = false;
		if (currentWord != null && currentWord.length() != 0) {
			try { 
				Integer.parseInt(currentWord);
				answer = true;
			} catch (NumberFormatException nfe) {}	
		}
		return answer;
	}

	private void getDataFromReader() throws IOException {
		int currentChar = 0;
		while (currentChar != -1) {
			currentChar = reader.read();
			buffer.append((char) currentChar);
		}
	}

	private String getNextWordFromBuffer() throws IOException {
		getDataFromReader();
		String answer = "";
		for (int i = 0; (i < buffer.length() 
				&& buffer.charAt(i) != delimiter 
				&& buffer.charAt(i) != endOfStringValue); i++) {
			answer += buffer.charAt(i);
		}
		buffer.delete(0, answer.length() + 1); // i.e. with delimiter
		return answer;
	}
	
	private String getNextLineFromBuffer() throws IOException {
		getDataFromReader();
		String answer = "";
		for (int i = 0; (i < buffer.length() 
				&& buffer.charAt(i) != endOfStringValue); i++) {
			answer += buffer.charAt(i);
		}
		buffer.delete(0, answer.length() + 1); 
		return answer;
	}


	public void useDelimiter(char delimiter) {
		checkScannerStatus();
		setDelimiter(delimiter);
	}

	@Override
	public void close() throws IOException {
		setMyScannerActive(false);
		if (this.reader != null) {
			this.reader.close();
		}
	}

	private void checkScannerStatus() throws IllegalStateException {
		if (!isMyScannerActive()) {
			throw new IllegalStateException();
		}
	}

	public char getDelimiter() {
		checkScannerStatus();
		return delimiter;
	}

	private void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	public boolean isMyScannerActive() {
		return myScannerActive;
	}

	private void setMyScannerActive(boolean myScannerActive) {
		this.myScannerActive = myScannerActive;
	}

}
