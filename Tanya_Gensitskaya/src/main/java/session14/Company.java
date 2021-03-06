package session14;

/**
 * Created by ZaR on 21.02.15.
 */

public class Company {


    private String capital;

    private String name;

    private Car car;

    private Man man;

    public Company() {
    }

    public Company(Car car, Man man) {
        this.car = car;
        this.man = man;
    }

    public Company(String capital, String name, Car car, Man man) {
        this.capital = capital;
        this.name = name;
        this.car = car;
        this.man = man;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("capital=").append(capital);
        sb.append(", name='").append(name).append('\'');
        sb.append(", car=").append(car);
        sb.append(", man=").append(man);
        sb.append('}');
        return sb.toString();
    }
}
