package Weekend_7_1;

/**
 * Created by sanya on 21.02.2015.
 */
public class Car {
    private Man driver;
    private String color;

    public Car() {
    }

    public Car(Man driver) {
        this.driver = driver;
    }

    public Car(Man driver, String color) {
        this.driver = driver;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +"driver=" + driver +", color='" + color + '\'' +'}';
    }

}
