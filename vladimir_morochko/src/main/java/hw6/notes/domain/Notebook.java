package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vladimir on 11.02.2015.
 *
 *  Создать DAO для таблицы ноутбуки
 Таблица ноутбуки имеет следующую структуру
 (id, serial, vendor, model, manufacture date, price)
 domain
 hw6.notes.domain.Notebook
 */

@Entity
@Table (name = "NOTEBOOKS")
public class Notebook {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "NOTEBOOK_ID")
    private Long id;

    String serial;
    String model;
    String vendor;
    Double price;

    @Temporal(TemporalType.DATE)
    @Column (name = "MANUFACTURE_DATE")
    Date date;

    public Notebook() {
    }

    public Notebook (String model, String vendor, Double price, Date date, String serial) {
        this.model = model;
        this.serial = serial;
        this.vendor = vendor;
        this.price = price;
        this.date = date;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notebook{id=" + id
                + ", model='" + model
                + "', vendor='" + vendor
                + "', price=" + price
                + ", date=" + String.format("%tF", date)
                + ", serial='" + serial
                + "'}";
    }
}
