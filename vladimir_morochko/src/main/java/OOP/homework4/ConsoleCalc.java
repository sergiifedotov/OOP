package OOP.homework4;

import java.util.Scanner;

/**
Написать калькулятор (класс hw2.ConsoleCalc) в виде консольного меню
	- сложение двух чисел
	- вычитание двух чисел
	- умножение двух чисел
	- деление двух чисел 
**/

public class ConsoleCalc {
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		Number[] numbers = new Number[2];
		int operation = 0;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			System.out.print("Введите " + (i + 1) + " число: ");
			if (scan.hasNextInt()) {
				numbers[i] = new Number (scan.nextInt());
			}
		}
		System.out.println("1 - сложение двух чисел ");
		System.out.println("2 - вычитание двух чисел ");
		System.out.println("3 - умножение двух чисел ");
		System.out.println("4 - деление двух чисел  ");
		while (!(operation == 1 || operation == 2 || operation == 3 || operation == 4)) {
			System.out.print("Выберите операцию: ");
			if (scan.hasNextInt()) {
				operation = scan.nextInt();
			}
		}
		switch (operation) {
		case 1: {
			numbers[0].add(numbers[1]);
			break;
		}
		case 2: {
			numbers[0].sub(numbers[1]);
			break;
		}
		case 3: {
			numbers[0].mul(numbers[1]);
			break;
		}
		case 4: {
			numbers[0].div(numbers[1]);
			break;
		}
		}
		System.out.println("Результат: " + numbers[0].get());

	}

	public ConsoleCalc() {
	}
}
