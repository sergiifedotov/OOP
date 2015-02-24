package session14.task1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by warit on 21.02.2015.
 */
@Component("car1")
public class Car {
    @Value("BMW")
    private String name;
    private String color;
    private Man driver;

    public Car() {
    }

    public Car(Man driver) {
        this.driver = driver;
    }

    public Car(String name, Man driver) {
        this.name = name;
        this.driver = driver;
    }

    public Car(String name, String color, Man driver) {
        this.name = name;
        this.color = color;
        this.driver = driver;
    }

    public Man getDriver() {
        return driver;
    }

    public void setDriver(Man driver) {
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", driver=" + driver +
                '}';
    }
}
