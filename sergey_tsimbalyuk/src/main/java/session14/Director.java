package session14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by tsv on 21.02.15.
 */
@Component
public class Director {
    @Value("JohnBasinsky")
    private String name;

    @Autowired(required = true)
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", car=" + car.getCarName()
                + '}';
    }
}
