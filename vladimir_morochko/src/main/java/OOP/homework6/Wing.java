package OOP.homework6;

/**
 * Создать класс Самолет на основе класса Крыло.
 * Классы Plane и Wing.
 * Самолет должен уметь:
 * - Взлетать (это возможно если в обоих крыльях достаточно топлива для взлета, 
 * которое тратится при взлете, метод void takeoff())
 * - Задавать маршрут (маршрут состоит из последовательности координат, 
 * метод void selectRoute(int[][] coordinates))
 * - Вывести на экран маршрут, метод void printRoute()
 *
 */

class Wing {
	private int fuel;
	final int fuelMax = 1500;
	
	public Wing () {
		
	}
	
	public Wing (int fuel) {
		setFuel(fuel);
	}
	
	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		if (fuel > fuelMax) {
			this.fuel = fuelMax;
		} else {
			this.fuel = fuel;
		}
	}

}
