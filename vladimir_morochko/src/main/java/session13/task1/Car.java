package session13.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by vladimir on 22.02.2015.
 */

public class Car {
    private String car_name;

    private Driver driver;

    public Car(){
    }

    public Car(String car_name, Driver driver){
        this.car_name = car_name;
        this.driver = driver;
    }

    public String getName() {
        return car_name;
    }

    public void setName(String name) {
        this.car_name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{car_name='" + car_name + "'"
                + ", driver=" + driver
                + "}";
    }
}
