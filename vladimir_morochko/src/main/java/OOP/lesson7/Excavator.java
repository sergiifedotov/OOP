package OOP.lesson7;

import OOP.lesson3.Car;

public class Excavator extends Car {
	private boolean digStatus;

	public Excavator() {
		super();
	}

	public Excavator(boolean engineStatus) {
		super(engineStatus);
	}

	public Excavator(boolean engineStatus, double fuel) {
		super(engineStatus, fuel);
	}
	
	public void work() {
		if (!isDigStatus() && getPoweredStatus()) {
			setDigStatus(true);
		}
	}
	
	public void doNotWork() {
		if (isDigStatus()) {
			setDigStatus(false);
		}
	}
	
	public boolean isDigStatus() {
		return digStatus;
	}

	public void setDigStatus(boolean digStatus) {
		this.digStatus = digStatus;
	}
}
