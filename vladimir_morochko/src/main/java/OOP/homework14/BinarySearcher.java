package OOP.homework14;

/**
 * Написать метод, выполняющий двоичный поиск ( рекурсивный) элемента в массиве.
 * Имя класса hw8.bsearch.BinarySearcher
 * 
 * public class BinarySearcher { public int binarySearch(int[] vector, int
 * elements) { } }
 */

public class BinarySearcher {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 };
		BinarySearcher mySearch = new BinarySearcher();
		for (int i = 0; i < 13; i++) {
			System.out.println(i + " : " + mySearch.binarySearch(arr, i));
		}
	}

	public int binarySearch(int[] vector, int elements) {
		return binarySearch(vector, elements, 0, vector.length - 1);
	}

	private int binarySearch(int[] vector, int value, int start, int end) {
		if (start > end) {
			return -1;
		} else {
			int middle = (start + end) / 2;
			if (vector[middle] < value) {
				return binarySearch(vector, value, ++middle, end);
			} else if (vector[middle] > value) {
				return binarySearch(vector, value, start, --middle);
			} else {
				return middle;
			}
		}
	}
}
