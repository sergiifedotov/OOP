package OOP.lesson5;

public class Bubble {
	public static void main(String[] args) {
		int[] vector = { 5, 0, 4, -3, 33, 2, 1, 7 };
		bubbleSort(vector);

		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public static void bubbleSort(int[] vector) {
		boolean sortNeeded = true;
		while (sortNeeded) {
			sortNeeded = false;
			for (int i = 0; i < vector.length - 1; i++) {
				if (vector[i] > vector[i + 1]) {
					int temp = vector[i];
					vector[i] = vector[i + 1];
					vector[i + 1] = temp;
					sortNeeded = true;
				}
			}
		}
	}
}
