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

public class Plane {
	Wing leftWing, rightWing;
	final int fuelNeededForTakeoff = 1000;
	private boolean flying;
	private int[][] coordinates;
	
	
	public Plane () {
		leftWing = new Wing();
		rightWing = new Wing();
	}

	public Plane (int fuel, int[][] coordinates) {
		leftWing = new Wing(fuel / 2);
		rightWing = new Wing(fuel / 2);
		setCoordinates(coordinates);
	}
	
	public void takeoff() {
		if ((leftWing.getFuel() + rightWing.getFuel()) >= fuelNeededForTakeoff) {
			setFlying(true);
			leftWing.setFuel(leftWing.getFuel() - fuelNeededForTakeoff / 2);
			rightWing.setFuel(rightWing.getFuel() - fuelNeededForTakeoff / 2);
		}
	}
	
	public void selectRoute(int[][] coordinates) {
		setCoordinates(coordinates);
	}
	
	public void printRoute() {
		for (int i = 0; i < getCoordinates().length; i++) {
			for (int j = 0; j < getCoordinates()[i].length; j++) {
				System.out.print(getCoordinates()[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean isFlying() {
		return flying;
	}
	
	public void explode() {
		leftWing = null;
		rightWing = null;
		System.out.println("*** BOOM! ***");
		setFlying(false);
	}

	public void setFlying(boolean flying) {
		this.flying = flying;
	}

	public int[][] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(int[][] coordinates) {
		this.coordinates = coordinates;
	}
}
