package OOP.homework6;

import java.util.Calendar;

/**
 * Создать класс Рыба на основе класса "Продукт в супермаркете".
 * Классы Fish и Product.
 * Рыба должна уметь:
 * - Вывести свою цену, метод void printPrice()
 * - Вывести срок хранения, метод void printStoragePeriod()
 * - Проплыть, метод void swim()
 * - Проглотить другую рыбу, метод void cannibalism(Fish fish)
 * - Вывести свой штрихкод и цену, метод void printBarAndPrice()
 *
 */

class Product {
	private int price;
	private String barcode;
	private Calendar storagePeriod;
	
	public Product() {
		
	}

	public Product(int price, Calendar storagePeriod) {
		setPrice(price);
		setStoragePeriod(storagePeriod);
	}
	
	public void printPrice() {
		System.out.println("Price is: " + getPrice());
	}
	
	public void printBarAndPrice() {
		System.out.println("Barcode is: " + getBarcode());
		printPrice();
	}
	
	public void printStoragePeriod() {
		System.out.println("Storage period is: " + getStoragePeriod().toString());
	}
	
	public void cannibalism(Product product) {
		setPrice(getPrice() + product.getPrice());
		product = null;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		}
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Calendar getStoragePeriod() {
		return storagePeriod;
	}

	public void setStoragePeriod(Calendar storagePeriod) {
		Calendar now = Calendar.getInstance();
		if (storagePeriod.compareTo(now) >= 0) {
			this.storagePeriod = now;
		} else {
			this.storagePeriod = storagePeriod;
		}
	}

}
