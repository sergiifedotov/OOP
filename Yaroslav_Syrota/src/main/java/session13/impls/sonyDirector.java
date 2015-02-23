package session13.impls;

import session13.interfaces.Car;
import session13.interfaces.Company;
import session13.interfaces.Director;

/**
 * Created by Admin on 21.02.2015.
 */

public class SonyDirector implements Director {
    private String name;
    private Car myCar;
    private Company company;



    public SonyDirector(){}

    public SonyDirector(String name, Car myCar, Company company) {
        this.name = name;
        this.myCar = myCar;
        this.company = company;
    }

    @Override
    public void driveCar() {
        System.out.println("I drive on my car");
        getMyCar().run();
    }

    @Override
    public void lead() {
        System.out.println("I lead");
        getCompany().work();
        driveCar();
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Car getMyCar() {
        return myCar;
    }
    public void setMyCar(Car myCar) {
        this.myCar = myCar;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
