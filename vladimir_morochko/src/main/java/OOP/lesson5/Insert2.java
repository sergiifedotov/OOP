package OOP.lesson5;

/**
 * Написать метод, выполняющий сортировку методом вставки
 *
 */

public class Insert2 {
	public static void main(String[] args) {
		int[] vector = { 5, 0, 4, -3, 33, 2, 1, 7 };
		insertSort(vector);

		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public static void insertSort(int[] vector) {
		int[] outVector = new int[vector.length];

		outVector[0] = vector[0];

		for (int i = 1; i < vector.length; i++) {
			int insertPosition = 0;
			for (int j = 0; j < i; j++) {
				if (vector[i] > outVector[j]) {
					insertPosition++;
				} else {
					break;
				}
			}
			for (int j = i; j > insertPosition; j--) {
				outVector[j] = outVector[j - 1];
			}
			outVector[insertPosition] = vector[i];
		}
		for (int i = 0; i < vector.length; i++) {
			vector[i] = outVector[i];
		}
	}
}
