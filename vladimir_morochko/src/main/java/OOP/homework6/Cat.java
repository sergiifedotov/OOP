package OOP.homework6;

import java.awt.Color;

/**
 * Создать класс Кошка на основе класса Животное.
 * Классы Cat и Animal.
 * Кошка должна уметь:
 * - Вывести на экран имя, метод void printName()
 * - Подать голос, метод void say()
 * - Поднимать шерсть дыбом, метод void riseHair()
 * - Питаться, метод void eat()
 * - Орать если ненаелась, метод void yellIfNotGorged()
 * 
 */


public class Cat extends Animal {
	private boolean hairRiseStatus;
	private Color colour;
	
	public void say() {
		System.out.println("Meow");
	}
	
	public void riseHair() {
		if(!isHairRiseStatus()) {
			setHairRiseStatus(true);
		}
	}
	
	public void yellIfNotGorged() {
		if (super.isHungry()) {
			System.out.println("Meow");
		}
	}
	
	public Cat() {
		super();
	}
	
	public Cat (String name) {
		super(name);
	}
	
	public Cat (String name, Color colour) {
		super(name);
		setColour(colour);
	}


	public boolean isHairRiseStatus() {
		return hairRiseStatus;
	}

	public void setHairRiseStatus(boolean hairRiseStatus) {
		this.hairRiseStatus = hairRiseStatus;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

}
