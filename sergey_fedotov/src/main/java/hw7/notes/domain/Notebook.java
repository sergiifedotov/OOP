package hw7.notes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *Создать сущности для базы данных "Магазин ноутбуков":
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)

 domain
 hw7.notes.domain.Notebook
 hw7.notes.domain.Vendor
 hw7.notes.domain.CPU
 hw7.notes.domain.Memory
 hw7.notes.domain.Store
 hw7.notes.domain.Sales
 */
@Entity
@Table(name="NOTEBOOKS")
public class Notebook {

    @Id
    @SequenceGenerator(name = "auto", sequenceName = "SEQ_NOTEBOOKS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto")
    @Column(name="ID")
    private Long id;

    @ManyToOne
    @Column(name="VENDOR")
    private Vendor vendor;

    @Column(name="MODEL")
    private String model;

    @Column(name="MANUFACTURE_DATE")
    private Date manufacture_date;

    @ManyToOne
    @Column(name="CPU")
    private CPU cpu;

    @ManyToOne
    @Column(name="MEMORY")
    private Memory memory;


    @Fetch(FetchMode.SELECT)
    @OneToMany
            (
                    fetch = FetchType.EAGER, // подргужать все сразу
                    mappedBy = "notebook", // включить двунаправленность
                    cascade = CascadeType.ALL // каскадирование
            )
    private List<Store> stores = new LinkedList<>();

    public Notebook() {
    }

    public Notebook(Vendor vendor, String model, Date manufacture_date, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufacture_date = manufacture_date;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public void addStore (Store store) {
        store.setNotebook(this);
        stores.add(store);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", model='" + model + '\'' +
                ", manufacture_date=" + manufacture_date +
                ", cpu=" + cpu +
                ", memory=" + memory +
                '}';
    }

}
