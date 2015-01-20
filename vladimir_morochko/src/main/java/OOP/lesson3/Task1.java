package OOP.lesson3;

// Пользователь вводит высоту и ширину двумерного массива (матрицы). Заполнить матрицу случайными числами [0..9] и вывести на экран.
// При вводе неверных размераов массива, выдавать сообщение "Не верный размер массива" и вызодить из программы.
// Перед вводом значений НЕ нужно пользователю выдавать сообщений, типа: "Введите ширину".
// Пример:
// 3
// 4
// 1234
// 5678
// 9123

import java.util.Scanner;

public class Task1 {

	public static void fillMatrixByRandom(int[][] matr) {
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = (int) (10 * Math.random());
			}
		}
	}

	public static void printMatrix(int[][] matr) {

		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				System.out.print(matr[i][j]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		if (n <= 0 || m <= 0) {
			System.out.println("Не верный размер массива");
		} else {
			int[][] matr = new int[n][m];
			fillMatrixByRandom(matr);
			printMatrix(matr);
		}
	}
}
