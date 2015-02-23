package session13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tsv on 21.02.15.
 */
@Component("car")
public class Car {
    private String model;
    private String  nameCar;
    private Human director;
    private String carName;

    public Human getDirector() {
        return director;
    }

    public void setDirector(Human director) {
        this.director = director;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public Car() {
    }

    public Car(String nameCar) {
        this.nameCar = nameCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameCar='" + nameCar + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public String getCarName() {
        return carName;
    }
}