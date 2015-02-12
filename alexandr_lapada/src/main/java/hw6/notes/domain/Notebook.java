package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sanya on 10.02.2015.
 */
@Entity
public class Notebook {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
    allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name = "NOTEBOOK_ID")
    private Long id;
    @Column(name = "SERIAL")
    private String serial;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;
    @Column(name = "PRICE")
    private Double price;

    public Notebook(){

    }

    public Notebook(Long id, String serial, String vendor, String model, Date date, Double price){
        this.id = id;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        //this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Long getId(){

        return id;
    }

    public String getSerial(){

        return serial;
    }

    public String getVendor(){

        return vendor;
    }

    public String getModel(){

        return model;
    }

    public Date getManufactureDate(){

        return manufactureDate;
    }

    public Double getPrice(){

        return price;
    }

    public void setId(Long id){

        this.id = id;
    }

    public void setSerial(String serial){

        this.serial = serial;
    }

    public void setVendor(String vendor){

        this.vendor = vendor;
    }

    public void setModel(String model){

        this.model = model;
    }

    public void setManufactureDate(Date manufactureDate){

        this.manufactureDate = manufactureDate;
    }

    public void setPrice(Double price){

        this.price = price;
    }
}
