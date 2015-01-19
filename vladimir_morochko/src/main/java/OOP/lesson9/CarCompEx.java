package OOP.lesson9;

/**
 * Отсортировать машины по убыванию года выпуска и производителя
 * (т.е. две одновременно)
 * сделать метод createCar()
 * Машина должна знать, сколько машин она сделала. 
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class CarCompEx {

	public static void main(String[] args) {
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(new Car(2000, "ZAZ"));
		list.add(new Car(2000, "AAZ"));
		list.add(new Car(1000, "Cesar"));
		list.add(new Car(3000, "Futurer"));

		Collections.sort(list);
		System.out.println(list);
	}
}

class Car implements Comparable<Car> {
	private int year;
	private String manufacturer;
	public static int carsMade;
	
	public static Car createCar() {
		return new Car();
	}


	public Car() {
		carsMade++;
	}

	public Car(int year, String manufacturer) {
		this(); // вызываем конструктор по умолчанию, чтобы не повторять код
		// если кода много, то это помогает
		this.year = year;
		this.manufacturer = manufacturer;
	}

	@Override
	public int compareTo(Car car) {
		if (year < car.year) {
			return 1;
		}
		if (year == car.year) {
			return this.getManufacturer().compareTo(car.getManufacturer());
		}
		if (year > car.year) {
			return -1;
		}
		return 0;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return manufacturer + "[" + year + "]";
	}
}
