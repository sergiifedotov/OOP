package hwOther;

/**
 * Created by tsv on 01.02.15.
 */
public class Park {
    private int numder;
    private String model;
    private String nameOfOwner;

    public int getNumder() {
        return numder;
    }

    public void setNumber(int number) {
        this.numder = number;
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

    public Park(int numder, String model, String nameOfOwner) {
        this.numder = numder;
        this.model = model;
        this.nameOfOwner = nameOfOwner;
    }
}

