package OOP.lesson5;

import java.util.Random;

/**
 * создать массив из 40 машинок, заправить их топливом (разное количество), 
 * завести все, попросить их проехать 40 километров и остановить (выключить)
 **/

/**
 * Для машины, кроме конструктора по умолчанию, реализовать конструктор со всеми
 * параметрами и конструктор с самыми основными параметрами
 * 
 **/

/**
 * Дан класс "машина", реализовать методы "заводиться" и "ехать". И еще метод
 * "заправляться", куда передается количество литров. В метод "ехать" мы
 * передаем количество километров, которое мы хотим проехать. Если не завелись,
 * не можем поехать. То же самое, если мало бензина. Если слишком много топлива,
 * то не давать заправляться.
 * 
 * Создать две машины, в одной 1 литр, в другой 100. Одна заведенная, вторая
 * нет. Нужно чтобы обе машины проехали 100 километров.
 **/

public class Task2 {
	public static void main(String[] args) {
		int desiredDistance = 40;
		int carNumber = 40;
		// создаем машинки
		Car1[] cars = new Car1[carNumber];
		for (int i = 0; i < cars.length; i++) {
			final Random rnd = new Random();
			double randomFuel = rnd.nextInt(10);
			cars[i] = new Car1(false, randomFuel);

			// если мало топлива, то заправляем
			if ((cars[i].getFuel() / cars[i].getConsumption() * 100) < desiredDistance) {

				System.out.println("car[" + i + "] has " + cars[i].getFuel()
						+ " fuel");
				double desiredFuel = desiredDistance / cars[i].getConsumption()
						- cars[i].getFuel();
				cars[i].setFuel(desiredFuel);
				System.out.println("Tanking car[" + i + "] with " + desiredFuel
						+ " fuel");
				System.out.println("Now car[" + i + "] has "
						+ cars[i].getFuel() + " fuel");
			} else {
				System.out.println("car[" + i + "] already has "
						+ cars[i].getFuel() + " fuel");
			}
			System.out.println();

			// если машина не заведена, заводим

			if (!cars[i].getPoweredStatus()) {
				System.out.println("Starting car[" + i + "]");
				cars[i].setPowerOn();
			} else {
				System.out.println("car[" + i + "] is already running");
			}

			System.out.println();

			// поехали

			cars[i].drive(desiredDistance);

			// остановка

			cars[i].setPowerOff();
			System.out.println("car[" + i + "] has been shut down");
		}
	}
}
