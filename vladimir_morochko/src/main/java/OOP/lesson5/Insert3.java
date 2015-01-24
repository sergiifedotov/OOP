package OOP.lesson5;

/**
 *  Написать метод, сортирующий массив сортировкой вставками.
 *  Вывести на экран пары индексов обмениваемых элементов 
 *  public void sortInsertion(int[] vector)
 *  Пример: 
 *  sortInsertion([3,1,2,3])
 *  0 1
 *  1 2
 */

public class Insert3 {

	public static void main(String[] args) {
		int[] vector = { 5, 0, 4, -3, 33, 2, 1, 7 };
		sortInsertion(vector);

		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public static void sortInsertion(int[] vector) {
		for (int i = 1; i < vector.length; i++) {
			if (vector[i] < vector[i - 1]) {
				int j = i;
				while (j > 0 && vector[j] < vector[j - 1]) {
					int temp = vector[j];
					vector[j] = vector[--j];
					vector[j] = temp;
					
					System.out.print(j + 1);
					System.out.print(" ");
					System.out.println(j);
				}
			}
		}
	}
}

