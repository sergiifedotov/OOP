package session13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ZaR on 21.02.15.
 */
@Scope
@Component("car")
public class Car {

    private String color;
    @Autowired
    private Man driver;

    public Car() {
    }

    public Car(Man man) {
        this.driver = man;
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
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("color='").append(color).append('\'');
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
