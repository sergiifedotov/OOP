package OOP.lesson13;

/**
 * Написать метод, который выводит на экран возрастающую последовательность
 * от 1 до n
 */

public class Recur1 {
	public static void main(String[] args) {
		System.out.println(nat(7));
	}
	
	public static String nat(int n) {
		if(n > 0) {
			return(nat(n - 1) + " " + n);
		} else {
			return "";
		}
	}

}
