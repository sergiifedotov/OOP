package OOP.lesson5;

/**
 * Написать метод, сортирующий массив методом выбора. 1) без использования
 * дополнительного массива 2) с использованием дополнительного массива
 */

public class Select {
	public static void main(String[] args) {
		int[] vector = { 6, 5, 4, 3, 2, 1 };
		selectSort(vector);
		
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public static void selectSort(int[] vector) {

		for (int i = 0; i < vector.length; i++) {
			int minPos = i;
			for (int j = i; j < vector.length; j++) {
				if (vector[j] < vector[minPos]) {
					minPos = j;
				}
			}
			int temp = vector[i];
			vector[i] = vector[minPos];
			vector[minPos] = temp;
		}
	}
}
