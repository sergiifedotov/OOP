package OOP.homework8;

/**
 * Пользователь вводит количество сортируемых чисел, 
 * затем вводит числа. 
 * Отсортировать введенные числа методом Шелла 
 * и вывести на экран пары индексов обмениваемых элементов.
 * Метод void sortShell(int[] vector)
 * Класс задания: ShellSorter
 * Пример:
 * sortShell([6, 2, 5, 4, 6, 5])
 * 3 0
 * 1 0
 * 5 4
 * 4 3
 */

public class ShellSorter {
	public static void main(String[] args) {
		int[] vector = { 6, 2, 5, 4, 6, 5 };
		// new ShellSorter().printVector(vector);
		new ShellSorter().sortShell(vector);
		// new ShellSorter().printVector(vector);
	}

	public void sortShell(int[] vector) {
		for (int step = vector.length / 2; step > 0; step /= 2) {
			for (int i = 0; i < vector.length - step; i++) {
				int j = i;
				while (j >= 0 && vector[j] > vector[j + step]) {
					int temp = vector[j];
					vector[j] = vector[j + step];
					vector[j + step] = temp;
					j--;
					System.out.println((j + step + 1) + " " + (j + 1));
				}
			}
		}
	}

	void printVector(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
		System.out.println();
	}
}
