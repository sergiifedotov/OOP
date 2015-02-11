package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by @CAT_Caterpiller on 10.02.2015.
 */

@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @SequenceGenerator(name="sequance",  sequenceName = "SEQ_NOTEBOOKS_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "serial")
    private String serial;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacture_date")
    private Date manufactureDate;

    @Column(name = "price")
    private Double price;


    public Notebook() {}

    public Notebook(String serial, String vendor, String model, Date manufactureDate, Double price) {
        super();
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }



    @Override
    public String toString() {
        return "id: " + getId() + " serial: " + getSerial() + " vendor: " + getVendor() + " model: " + getModel()
                + " manufacture date: " + getManufactureDate() + " Price: " + getPrice();
    }






    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Date getManufactureDate() {
        return manufactureDate;
    }
    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
