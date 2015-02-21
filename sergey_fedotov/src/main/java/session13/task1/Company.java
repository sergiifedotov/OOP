package session13.task1;

/**
 * Created by warit on 21.02.2015.
 */
public class Company {
    private String name;
    private Double charterCapital;
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

    public Company(String name, Double charterCapital, Car car) {
        this.name = name;
        this.charterCapital = charterCapital;
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

    public Double getCharterCapital() {
        return charterCapital;
    }

    public void setCharterCapital(Double charterCapital) {
        this.charterCapital = charterCapital;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", charterCapital=" + charterCapital +
                ", car=" + car +
                '}';
    }
}
