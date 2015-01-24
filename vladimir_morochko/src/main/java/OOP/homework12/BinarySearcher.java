package OOP.homework12;

/**
 * Написать метод, выполняющий двоичный поиск (не рекурсивный) элемента в массиве.
 *
 */

public class BinarySearcher {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(new BinarySearcher().binarySearch(arr, 7));
	}
	
	public int binarySearch(int[] vector, int elements) {
		int answer = -1;
		if (vector.length > 0 && elements >= vector[0] && elements <= vector[vector.length - 1]) {
			// int iterations = (int) (Math.log(vector.length) / Math.log(2.0));
			int searchStart = 0;
			int searchEnd = vector.length - 1;
			
			boolean found = false;
			while (!found) {
				int middle = (searchStart + searchEnd) / 2;
				
				if (vector[middle] < elements) {
					searchStart = ++middle;
				} else if (vector[middle] > elements) {
					searchEnd = --middle;
				} else {
					found = true;
					answer = middle;
				}
				if (searchEnd == searchStart) {
					found = true;
				}
			}
		}
		return answer;
	}
}
