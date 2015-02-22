package session13_14;

/**
 * Created by Chuvychin on 21.02.2015.
 */
public class Company {
    private Man boss;
    private Car car;
    private String name;
    private double capital;

    public Company(Man boss, Car car, String name, double capital) {
        this.boss = boss;
        this.car = car;
        this.name = name;
        this.capital = capital;
    }

    public Company(Man boss, Car car, String name) {
        this.boss = boss;
        this.car = car;
        this.name = name;
    }

    public Company(Man boss, String name) {
        this.boss = boss;
        this.name = name;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return "Company{" +
                "boss=" + boss +
                ", car=" + car +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                '}';
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Man getBoss() {
        return boss;
    }

    public void setBoss(Man boss) {
        this.boss = boss;
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
}
