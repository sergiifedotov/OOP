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

public class Fish extends Product {
	private String name;
	private boolean swimming;

	public Fish() {
		super();
	}

	public Fish(int price, Calendar storagePeriod, String name) {
		super(price, storagePeriod);
		setName(name);
	}

	public void swim() {
		if (!isSwimming()) {
			setSwimming(true);
		}
	}

	// @Override
	public void cannibalism(Fish fish) {
		super.cannibalism(fish);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSwimming() {
		return swimming;
	}

	public void setSwimming(boolean swimming) {
		this.swimming = swimming;
	}
}
