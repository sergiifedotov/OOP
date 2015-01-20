package OOP.lesson3;

public class MarkerDemo {

	/*
	 * создать 2 маркера - зеленый и белый и вывести их на екран
	 */

	public static void main(String[] args) {
		Marker marker1 = new Marker();
		marker1.size = 12;
		marker1.color = "green";
		marker1.price = 10.20;
		Marker marker2 = new Marker();
		marker2.size = 12;
		marker2.color = "white";
		marker2.price = 10.10;
		System.out.println(marker1.color);
		System.out.println(marker2.color);
		marker2.print();

	}

}

class Marker {
	int size;
	String color;
	double price, weight;

	public void print() {
		System.out.println("ерунда всякая");
	}
}