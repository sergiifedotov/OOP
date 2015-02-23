package Weekend_7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sanya on 22.02.2015.
 */
@Component
public class Company {
    @Value("Apple")
    private String name;
    @Autowired
    private Man director;
    @Autowired
    private Car car;

    public Company() {
    }

    public Company(Man director, Car car) {
        this.director = director;
        this.car = car;
    }

    public Man getDirector() {
        return director;
    }

    public void setDirector(Man director) {
        this.director = director;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Company{" +"name="+ name +", director=" + director + ", car=" + car +'}';
    }
}
