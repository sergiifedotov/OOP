package OOP.homework6;

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

class Animal {
	private String name;
	private boolean hungry;

	public void printName() {
		System.out.println(getName());
	}
	
	public void eat () {
		if (isHungry()) {
			setHungry(false);
		}
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHungry() {
		return hungry;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}
	
	public Animal () {
		setHungry(true);
	}
	
	public Animal (String name) {
		setHungry(true);
		setName(name);
	}
}
