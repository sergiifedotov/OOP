package session13_14.session14;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Chuvychin on 22.02.2015.
 */

@Scope("prototype")
@Component
public class Company {

    @Autowired
    private Man boss;
    @Autowired
    private Car car;
    @Value("BigBrotherWorld")
    private String name;
    @Value("1000000.00")
    private double capital;

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

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }
}
