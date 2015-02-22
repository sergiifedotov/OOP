package session13_14.session14;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Chuvychin on 22.02.2015.
 */

@Scope ("prototype")
@Component
public class Car {

    @Autowired
    private Man driver;

    @Value("KySoK PiRoGa")
    private String number;

    @Value("eDiNoRogMeTal")
    private String color;

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "driver=" + driver +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Man getDriver() {
        return driver;
    }

    public void setDriver(Man driver) {
        this.driver = driver;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
