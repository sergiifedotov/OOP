package OOP.lesson3;

public class Car {
	private boolean isOn;

	public boolean getPoweredStatus() {
		return this.isOn;
	}

	public void setPowerOn() {
		this.isOn = true;
	}

	public void setPowerOff() {
		this.isOn = false;
	}

	private double fuelCapacity;
	private double consumptionPer100Km = 10;

	public double getConsumption() {
		return this.consumptionPer100Km;
	}

	private double fuel;

	public double getFuel() {
		return this.fuel;
	}
	
	public void work() {
		
	}


	public double setFuel(double fuelAmount) {
		if (fuelAmount > 0) {
			this.fuel += fuelAmount;
			if (this.fuel > fuelCapacity) {
				this.fuel = fuelCapacity;
			}
		}
		return this.fuel;
	}

	public boolean drive(int distance) {
		if ((this.fuel >= distance / this.consumptionPer100Km) && this.isOn) {
			this.fuel -= distance / this.consumptionPer100Km;
			System.out.println("Car has driven " + distance + " km");
			System.out.println("Fuel left " + this.fuel + " fuel");
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

	public Car() {
		this.fuelCapacity = 100;
		System.out.println("A car is created");
	}

	public Car(boolean engineStatus) {
		this.fuelCapacity = 100;
		this.fuel = 10;
		this.isOn = engineStatus;
		System.out.println("A car with " + this.isOn
				+ " engine status is created");
		System.out.println();
	}

	public Car(boolean engineStatus, double fuel) {
		this.fuelCapacity = 100;
		if (fuel > this.fuelCapacity) {
			this.fuel = this.fuelCapacity;
		} else {
			this.fuel = fuel;
		}
		this.isOn = engineStatus;
		System.out.println("A car with " + this.fuel + " fuel and " + this.isOn
				+ " engine status is created");
		System.out.println();
	}
}