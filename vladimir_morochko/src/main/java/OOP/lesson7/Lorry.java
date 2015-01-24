package OOP.lesson7;

import OOP.lesson3.Car;

public class Lorry extends Car {
	private double weightCapacity;
	private double loadedWeight;

	public Lorry() {
		super();
	}

	public Lorry(boolean engineStatus) {
		super(engineStatus);
	}

	public Lorry(boolean engineStatus, double fuel) {
		super(engineStatus, fuel);
	}
	
	public Lorry(boolean engineStatus, double fuel, double weightCapacity) {
		super(engineStatus, fuel);
		setWeightCapacity(weightCapacity);
	}
	
	public void load(int weight) {
		if (weight <= this.getWeightCapacity() && weight > 0) {
			this.loadedWeight = weight;
		} else {
			this.loadedWeight = this.getWeightCapacity();
		}
	}
	
	public void work() {
		drive(100);
	}
	
	public double unLoad() {
		double temp = this.loadedWeight;
		this.loadedWeight = 0;
		return temp;
	}
	
	public double getWeightCapacity() {
		return weightCapacity;
	}

	public void setWeightCapacity(double weightCapacity) {
		this.weightCapacity = weightCapacity;
	}
}
