package OOP.lesson7;

import java.util.ArrayList;

import OOP.lesson3.Car;

/**
 * Создать класс "грузовик", который умеет возить груз определенного веса, умеет
 * его загружать и выгружать. Написать класс "экскаватор", который умеет копать.
 * 
 * Создать парк машин, состоящий из 10 экскаваторов и 20 грузовиков. 
 * Заправить все машины парка, завести только грузовики, отправить всех на работу
 * (не заведенные должны отказаться ехать). 
 * 
 */

public class Task1 {
	public static void main(String[] args) {
		
		ArrayList <Car> vehiclePool = new ArrayList <Car>();
		for (int i = 0; i < 10; i++) {
			vehiclePool.add(new Lorry());
		}
		for (int i = 0; i < 20; i++) {
			vehiclePool.add(new Excavator());
		}
		
		for (Car car: vehiclePool) {
			car.setFuel(100);
			car.work();
		}

	}
}

