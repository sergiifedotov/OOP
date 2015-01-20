package OOP.lesson11;

/**
 * Написать класс "пара", хранящий два значения любых типов.
 * 
 * 
 */

public class Pair<T, K> {
	
	public static void main(String[] args) {
		Pair<Integer, String> myPair = new Pair<Integer, String>(10, "10");
		System.out.print(myPair);
	}
	
	private T value1;
	private K value2;
	
	public Pair(T value1, K value2) {
		this.setValue1(value1);
		this.setValue2(value2);
	}

	public T getValue1() {
		return value1;
	}

	public void setValue1(T value1) {
		this.value1 = value1;
	}

	public K getValue2() {
		return value2;
	}

	public void setValue2(K value2) {
		this.value2 = value2;
	}

}
