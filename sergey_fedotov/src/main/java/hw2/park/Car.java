package hw2.park;

/**
 *
 */
public class Car {

    private String registrationNumber;

    public Car(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object car){

        if (car == null)
            return false;
        if (getClass() != car.getClass())
            return false;
        Car other = (Car) car;

        return (registrationNumber.equals(other.registrationNumber));
    }

    @Override
    public int hashCode() {
        return registrationNumber.hashCode();
    }

}
