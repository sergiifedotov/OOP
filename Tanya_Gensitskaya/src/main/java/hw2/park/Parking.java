package hw2.park;

import java.util.HashMap;
import java.util.Map;

/**
 * написать класс представляющий парковку. С методами:
 * - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 * - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 * Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException
 * <p/>
 * Написать модульный тест на класс Parking.
 * <p/>
 * Классы задания:
 * hw2.park.Parking
 * hw2.park.Car
 */

public class Parking {
    private Map<String, Car> parking = new HashMap<>(); //карта хранит номер парко-места и номер машины
    private static int count = 0; //  для проверки наличия свободного номера парко-места
    private static final int COUNT_PARK_SPACE = 6; // макс. к-во машин на парковке

    public Parking() {
    }


    public int park(Car car) {
        count = 0;
        for (int i = 0; i < COUNT_PARK_SPACE; i++) {
            count++;
            if (!parking.containsKey("" + count)) {
                parking.put("" + count, car);
                return count;
            }
        }
        if (count == COUNT_PARK_SPACE) {
            try {
                throw new ParkFullException();
            } catch (ParkFullException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public Car leave(int placeNumber) {
        Car carRemove;
        if (placeNumber > 0 && placeNumber <= COUNT_PARK_SPACE) {
            carRemove = parking.get("" + placeNumber); // возвращает обьект по указанному ключу
            if (carRemove != null) {
                parking.remove("" + placeNumber); // удаляет обьект по указанному ключу
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return carRemove;
    }


    public void showPlaceNumber() {  // просмотр занятых паркомест
        for (Map.Entry<String, Car> elem : parking.entrySet()) {
            String key = elem.getKey();
            Car value = elem.getValue();
            System.out.println(key + " " + value);
        }
    }

}



