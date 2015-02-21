package session13.task1;

/**
 * Created by warit on 21.02.2015.
 */
public class Company {
    private String name;
    private Car car;

    public Company() {
    }

    public Company(Car car) {
        this.car = car;
    }

    public Company(String name, Car car) {
        this.name = name;
        this.car = car;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
