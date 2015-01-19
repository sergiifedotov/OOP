package OOP.lesson3;

// Дан класс "машина", реализовать методы "заводиться" и "ехать". 
// И еще метод "заправляться", куда передается количество литров. 
// В метод "ехать" мы передаем количество километров, 
// которое мы хотим проехать. Если не завелись, не можем поехать. 
// То же самое, если мало бензина. Если слишком много топлива, то не 
// давать заправляться. 
//
// Создать две машины, в одной 1 литр, в другой 100. Одна заведенная, вторая нет. 
// Нужно чтобы обе машины проехали 100 километров. 

// 

public class Task2 {

	public static void main(String[] args) {

		int desiredDistance = 100;

		Car car1 = new Car();
		car1.setFuel(1);
		car1.setPowerOff();

		Car car2 = new Car();
		car2.setFuel(100);
		car2.setPowerOn();

		// если машина не заведена, заводим
		if (!car1.getPoweredStatus()) {
			System.out.println("Starting car1");
			System.out.println();
			car1.setPowerOn();
		} else {
			System.out.println("car1 is already running");
			System.out.println();
		}

		if (!car2.getPoweredStatus()) {
			System.out.println("Starting car2");
			System.out.println();
			car2.setPowerOn();
		} else {
			System.out.println("car2 is already running");
			System.out.println();
		}

		// если мало топлива, то заправляем
		if ((car1.getFuel() / car1.getConsumption() * 100) < desiredDistance) {

			System.out.println("car1 has " + car1.getFuel() + " fuel");
			double desiredFuel = desiredDistance / car1.getConsumption()
					- car1.getFuel() + 5;
			car1.setFuel(desiredFuel);
			System.out.println("Tanking car1 with " + desiredFuel + " fuel");
			System.out.println("Now car1 has " + car1.getFuel() + " fuel");
			System.out.println();
		} else {
			System.out.println("car1 already has " + car1.getFuel() + " fuel");
			System.out.println();
		}

		if ((car2.getFuel() / car2.getConsumption() * 100) < desiredDistance) {

			System.out.println("car2 has " + car2.getFuel() + " fuel");
			double desiredFuel = desiredDistance / car2.getConsumption()
					- car2.getFuel() + 5;
			car2.setFuel(desiredFuel);
			System.out.println("Tanking car2 with " + desiredFuel + " fuel");
			System.out.println("Now car2 has " + car2.getFuel() + " fuel");
			System.out.println();
		} else {
			System.out.println("car2 already has " + car2.getFuel() + " fuel");
			System.out.println();
		}

//		System.out.println(car1.drive(desiredDistance));
//		System.out.println(car2.drive(desiredDistance));
		car1.drive(desiredDistance);
		car2.drive(desiredDistance);


	}
}