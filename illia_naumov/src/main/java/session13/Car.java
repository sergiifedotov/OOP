package session13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by illia_naumov on 21.02.2015.
 */
//@Scope
//@Component("car")
public class Car {
    //@Autowired
    private Man driver;
    //@Value("${color}")
    private String color;

    public Car(){

    }
    public String getColor() {
        return color;
    }


    public Car(String color, Man driver) {
        this.color = color;
        this.driver = driver;
    }

    public Car(String color) {
        this.color = color;
    }

    public Car(Man driver) {
        this.driver = driver;
    }

    public Man getDriver() {
        return driver;
    }

    public void setDriver(Man driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "My driver is " + driver;
    }


    public void setColor(String color) {
        this.color = color;
    }
}
