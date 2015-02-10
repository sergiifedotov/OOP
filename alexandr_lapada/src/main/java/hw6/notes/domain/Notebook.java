package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sanya on 10.02.2015.
 */
public class Notebook {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID",
    allocationSize = 2, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column(name = "NOTEBOOK_ID")
    private Long id;
    @Column(name = "SERIAL")
    private Long serial;
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

    public Notebook(Long id, Long serial, String vendor, String model/*, Date date*/, Double price){
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

    public Long getSerial(){

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

    public void setId(){

        this.id = id;
    }

    public void setSerial(){

        this.serial = serial;
    }

    public void setVendor(){

        this.vendor = vendor;
    }

    public void setModel(){

        this.model = model;
    }

    public void setManufactureDate(){

        this.manufactureDate = manufactureDate;
    }

    public void setPrice(){

        this.price = price;
    }
}
