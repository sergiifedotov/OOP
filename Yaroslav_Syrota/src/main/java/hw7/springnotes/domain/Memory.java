package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by vladimir on 17.02.2015.
 *
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
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
@Table(name = "MEMORY")
public class Memory {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORY_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "MEMORY_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;
    private long capacity;

    public Memory() {
    }

    public Memory(Vendor vendor, long capacity) {
        this.vendor = vendor;
        this.capacity = capacity;
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

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long size) {
        this.capacity = size;
    }

    @Override
    public String toString() {
        return "Memory{id=" + id
                + ", vendor=" + vendor
                + ", capacity=" + capacity
                + "}";
    }
}
