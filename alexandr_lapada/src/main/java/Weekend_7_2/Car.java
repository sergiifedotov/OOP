package Weekend_7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sanya on 22.02.2015.
 */
@Component
public class Car {
    @Autowired
    private Man driver;
    @Value("Black")
    private String color;

    public Car() {
    }

    public Car(Man driver, String color) {
        this.driver = driver;
        this.color = color;
    }

    public Man getDriver() {
        return driver;
    }

    public void setDriver(Man driver) {
        this.driver = driver;
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
                "driver=" + driver +
                ", color='" + color + '\'' +
                '}';
    }
}
