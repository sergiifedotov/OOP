package session13.impls;

import session13.interfaces.Car;

/**
 * Created by Admin on 21.02.2015.
 */

public class DirectCar implements Car {
    private String model;

    @Override
    public void run() {
        System.out.println("Im run with my director)");
    }


    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

}
