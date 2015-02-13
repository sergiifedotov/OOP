package hw6.notes.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;

/**
 *Создать DAO для таблицы ноутбуки
 Таблица ноутбуки имеет следующую структуру
 (id, serial, vendor, model, manufacture date, price)
 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook ntb)
 Notebook read(Long ig)
 boolean update(Notebook ntb)
 boolean delete(Notebook ntb)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 */
@Entity
@Table(name="NOTEBOOKS")
public class Notebook {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_NOTEBOOKS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="ID")
    private Long id;

    @Column(name="SERIAL")
    private String serial;

    @Column(name="VENDOR")
    private String vendor;

    @Column(name="MODEL")
    private String model;

    @Column(name="MANUFACTURE_DATE")
    private GregorianCalendar manufacture_date;

    @Column(name="PRICE")
    private Double price;

    public Notebook() {
    }

    public Notebook(String serial, String vendor, String model, GregorianCalendar manufacture_date, Double price) {
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufacture_date = manufacture_date;
        this.price = price;
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

    public GregorianCalendar getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(GregorianCalendar manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", manufacture_date=" + manufacture_date +
                ", price=" + price +
                '}';
    }
}
