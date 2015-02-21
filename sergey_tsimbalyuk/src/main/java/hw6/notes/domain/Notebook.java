package hw6.notes.domain;

import javax.persistence.*;

/**
 * Created by tsv on 09.02.15.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")


    @Column(name = "NOTEBOOK_ID")
    private Long id;

    @Column(name = "NOTEBOOK_SERIAL")
    private String serial;

    @Column(name = "NOTEBOOK_VENDOR")
    private String vendor;

    @Column(name = "NOTEBOOK_MODEL")
    private String model;

    @Column(name = "NOTEBOOK_MANUFACTURE")
    private String manufacture;

    @Column(name = "NOTEBOOK_DATE")
    private String date;

    @Column(name = "NOTEBOOK_PRICE")
    private String price;

    public Notebook() {
    }

    public Notebook(String serial,  String model, String vendor,String manufacture,String date, String price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufacture = manufacture;
        this.date = date;
        this.price = price;
        this.id = new Long(0);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getId() {

        return id;
    }

    public String getSerial() {
        return serial;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "NOTEBOOK: id = " + id +
                ", serial = " + serial +
                ", model = " + model +
                ", vendor = "+ vendor +
                ", manufacture = " + manufacture +
                ", price = " + price + "$;";
    }
}