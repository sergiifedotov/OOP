package session14;

/**
 * Created by ZaR on 21.02.15.
 */

public class Car {

    private String color;

    private Man driver;

    public Car() {
    }

    public Car(Man man) {
        this.driver = man;
    }

    public Car(String color, Man driver) {
        this.color = color;
        this.driver = driver;
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
