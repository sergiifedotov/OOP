package session13.task1;

/**
 * Created by warit on 21.02.2015.
 */
public class Car {
    private String name;
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", driver=" + driver +
                '}';
    }
}
