package session13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by stan on 21.02.15.
 */
@Component
public class Car {
   @Autowired(required = true)
   private Man director;
@Value("532645")
    private String number;

    @Value("TeslaMotors")
    private String model;
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Car(String number) {
        this.number = number;
    }
    public Car (){

    }



    public Man getDirector() {
        return director;
    }

    public void setDirector(Man director) {
        this.director = director;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", man=" + director +
                ", model='" + model + '\'' +
                '}';
    }
}
