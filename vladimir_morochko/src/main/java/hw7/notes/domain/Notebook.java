package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vladimir on 11.02.2015.
 *
 *  1. Создать сущности для базы данных "Магазин ноутбуков":
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
@Table (name = "NOTEBOOKS")
public class Notebook {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "NOTEBOOK_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;
    private String model;

    @Temporal(TemporalType.DATE)
    @Column (name = "MANUFACTURE_DATE")
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    private CPU cpu;
    @ManyToOne(fetch = FetchType.EAGER)
    private Memory memory;

    public Notebook() {
    }

    public Notebook (Vendor vendor, String model, Date date, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.date = date;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }


    @Override
    public String toString() {
        return "Notebook{id=" + id
                + ", vendor=" + vendor
                + ", model='" + model
                + "', date=" + String.format("%tF", date)
                + ", CPU=" + cpu
                + ", memory=" + memory
                + "}";
    }
}
