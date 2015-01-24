package OOP.homework12;

public class PartialSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 6, 5, 7, 4, 8, 3, 9, 1, 2 };

		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();

		int sortBase = 5;
		int firstSwapIndex = 0;
		int lastSwapIndex = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			while (arr[firstSwapIndex] < sortBase
					&& firstSwapIndex < arr.length) {
				firstSwapIndex++;
			}
			while (arr[lastSwapIndex] > sortBase && lastSwapIndex > 0) {
				lastSwapIndex--;
			}

			int temp = arr[firstSwapIndex];
			arr[firstSwapIndex] = arr[lastSwapIndex];
			arr[lastSwapIndex] = temp;
		}
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
