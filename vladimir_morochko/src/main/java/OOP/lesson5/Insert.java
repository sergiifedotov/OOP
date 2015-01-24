package OOP.lesson5;

public class Insert {
	public static void main(String[] args) {
		int[] vector = { 6, 6, 5, 5, 4 };
		insertSort(vector);

		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public static void insertSort(int[] vector) {
		for (int i = 1; i < vector.length; i++) {
			int insertPosition = i;
			int temp = vector[insertPosition];
			while (insertPosition > 0 && temp < vector[insertPosition - 1]) {
				vector[insertPosition] = vector[--insertPosition];
			}
			if (i != insertPosition) {
				vector[insertPosition] = temp;
			}	
		}
	}
}
