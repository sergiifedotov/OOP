package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 Создать DAO для таблицы ноутбуки
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
@Table(name="NOTEBOOK")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name="ID")
    private Long id;

    @Column(name="SERIAL")
    private String serial;

    @Column(name="VENDOR")//продавец
    private String vendor;

    @Column(name="MODEL")
    private String model;

    @Temporal(TemporalType.DATE)
    @Column(name="MANUFACTURE_DATE")
    private Date manufactureDate;

    @Column(name="PRICE")
    private Double price;


    public Notebook() {
    }

    public Notebook(Double price, String serial, String vendor, String model, Date manufactureDate) {
        this.price = price;
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
    }


    @Override
    public String toString() {
            return "Notebook  " +
            "id=" + id +
            ", serial='" + serial+
            ", vendor='" + vendor+
            ", model='" + model+
            ", manufactureDate='" + manufactureDate +
            ", price='" + price+
            '}';
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
