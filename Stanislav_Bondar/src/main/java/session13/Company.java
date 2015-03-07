package session13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Company {
@Value("Motorola")
private String name;
@Autowired(required = true)
    private Man director;

    @Autowired(required = true)
    private Car car;

    public Company(Car car) {
        this.car = car;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(){

    }

    public Company(String name, Man director) {
        this.name = name;
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
        return "Company{" +
                "name='" + name +"," +
                " director=" + director +"," + '\n' +
                " car=" + car +
                '}';
    }


}
