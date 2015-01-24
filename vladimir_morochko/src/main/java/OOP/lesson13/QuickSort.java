package OOP.lesson13;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. User: al1 Date: 10/7/13
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] vector = { 4, 3, 2, 4, 3, 6, 1, 2, 3, 5, 1, 6, 9, 6, 6 };

		quickSort(vector, 0, vector.length - 1);
		System.out.println(Arrays.toString(vector));
	}

	public static void quickSort(int[] vector, int left, int right) {
		int l = left;
		int r = right;
		int pivotIndex = (left + right) / 2;
		int pivot = vector[pivotIndex];
		while (l <= r) {
			while (vector[l] < pivot) {
				l++;
			}

			while (vector[r] > pivot) {
				r--;
			}
			if (l <= r) {
				swap(vector, l++, r--);
			}
		}
		if (left < r) {
			quickSort(vector, left, r);
		}
		if (l < right) {
			quickSort(vector, l, right);
		}
	}

	private static void swap(int[] vector, int l, int r) {
		int tmp = vector[l];
		vector[l] = vector[r];
		vector[r] = tmp;
	}
}