package OOP.lesson13;

/**
 * Написать метод, принимающий целое число и возвращающий сумму всех чисел
 * от 1 до этого числа
 * 
 */

public class Recur2 {
	public static void main(String[] args) {
		int n = 100;
		System.out.println(sumNat(n));
	}
	
	public static int sumNat(int n) {
		return (int)((1.0 + n) / 2 * n);
//		if (n > 0) {
//			return n + sumNat(n - 1);
//		} else {
//			return 0;
//		}
	}

}
