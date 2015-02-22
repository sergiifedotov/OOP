package hw7.notes;

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
 Notebook
 Vendor
 CPU
 Memory
 Store
 Sales
 */
@Entity
@Table(name = "VENDORS")
public class Vendor {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDOR_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "VENDOR_ID")
    private Long id;

    private String name;

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vendor{id=" + id
                + ", name='" + name
                + "'}";
    }
}
