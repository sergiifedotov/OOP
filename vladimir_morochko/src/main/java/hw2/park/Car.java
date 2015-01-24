package hw2.park;

/**
 * Created by vladimir on 23.01.2015.
 *
 * Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку,
 возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки
 по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException
 и ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car

 */
public class Car {
    private String model;
    private String colour;

 public Car() {
    model = new String("Opel");
    colour = new String("white");
 }

 public Car(String model, String colour) {
    this();
    this.model = model;
    this.colour = colour;
 }

 @Override
 public String toString() {
    return colour + " " + model;
 }

 public String getColour() {
    return colour;
 }
 public void setColour(String colour) {
    this.colour = colour;
 }
 public String getModel() {
    return model;
 }
 public void setModel(String model) {
    this.model = model;
 }

}
