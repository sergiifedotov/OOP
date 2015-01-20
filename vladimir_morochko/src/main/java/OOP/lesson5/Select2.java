package OOP.lesson5;

/**
 * Написать метод, сортирующий массив методом выбора. 1) без использования
 * дополнительного массива 2) с использованием дополнительного массива
 */

public class Select2 {
	public static void main(String[] args) {
		int[] vector = { 6, 5, 4, 3, 2, 1 };
		selectSort2(vector);
		
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public static void selectSort2(int[] vector) {
		int[] outVector = new int[vector.length];
		boolean[] boolVector = new boolean[vector.length];

		for (int i = 0; i < outVector.length; i++) {
			int minPos = 0;
			for (int j = 0; j < vector.length; j++) {
				if (vector[j] <= vector[minPos] && !boolVector[j]) {
					minPos = j;
				}
			}
			boolVector[minPos] = true;
			outVector[i] = vector[minPos];
		}
		for (int i = 0; i < vector.length; i++) {
			 vector[i] = outVector[i];
		}
	}
}
