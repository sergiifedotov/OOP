package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Chuvychin on 09.02.2015.
 */

@Entity //defoult
@Table (name = "NOTEBOOKS")
public class Notebook {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGION_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private String serial;

    private String vendor;

    private String model;

    @Temporal(TemporalType.DATE)
    @Column (name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    private double price;

    public Notebook(){

    }

    @Override
    public String toString(){
        return "id: "+id+" serial: "+serial+" vendor: "+vendor+" model: "+model+" manufacture_date: "+manufactureDate+" price: "+price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
