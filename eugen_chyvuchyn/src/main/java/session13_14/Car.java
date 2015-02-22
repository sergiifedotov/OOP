package session13_14;

/**
 * Created by Chuvychin on 21.02.2015.
 */
public class Car {
    private Man driver;
    private String number;
    private String color;

    public Car(Man driver, String number, String color) {
        this.driver = driver;
        this.number = number;
        this.color = color;
    }

    public Car(Man driver, String number) {
        this.driver = driver;
        this.number = number;
    }

    public Car(Man driver) {
        this.driver = driver;
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}
