package Parking;

public class Car {
    private int numder;
    private String model;
    private String nameOfOwner;

    public int getNumder() {
        return numder;
    }

    public void setNumder(int numder) {
        this.numder = numder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }



    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public Car(int numder, String model, String nameOfOwner) {
        this.numder = numder;
        this.model = model;
        this.nameOfOwner = nameOfOwner;
    }
}
