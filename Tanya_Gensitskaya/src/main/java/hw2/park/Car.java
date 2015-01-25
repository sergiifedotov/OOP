package hw2.park;

/**
 * Created by Tanya on 21.01.2015.
 */
public class Car {
    private int numberCar;


    public Car(int numberCar) {
        this.numberCar = numberCar;
    }

    public int getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(int numberCar) {
        this.numberCar = numberCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberCar=" + numberCar +
                '}';
    }
}
