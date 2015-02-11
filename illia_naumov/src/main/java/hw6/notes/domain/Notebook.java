package hw6.notes.domain;

import javax.persistence.*;

/**
 * Created by illia_naumov
 */
@Entity
@Table(name = "notebooks")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "notebook_id",
    allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "SERIAL")
    private String serial;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private String manufactureDate;

    @Column
    private int price;

    public Notebook(){
        
    }

    public Notebook( String serial, String vendor, String model, String manufactureDate, int price){
        //this.id = id;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    //<editor-fold desc="Setters">
    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setId(long id) {
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public int getPrice() {
        return price;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public String getModel() {
        return model;
    }

    public String getVendor() {
        return vendor;
    }

    public String getSerial() {
        return serial;
    }

    public long getId() {
        return id;
    }
    //</editor-fold>

    @Override
    public String toString(){
        return "Id: " + id + "- serial: " + serial + ", vendor:" + vendor + ", model:" + model
                + ", manufacture date:" + manufactureDate + ", price: " + price;
    }
}
