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
 hw7.springnotes.domain.Notebook
 hw7.springnotes.domain.Vendor
 hw7.springnotes.domain.CPU
 hw7.springnotes.domain.Memory
 hw7.springnotes.domain.Store
 hw7.springnotes.domain.Sales
 */

@Entity
@Table(name = "CPU")
public class CPU {
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Id
    @Column (name = "CPU_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;
    private Long speed;
    private String model;

    public CPU() {
    }

    public CPU(Vendor vendor, Long speed, String model) {
        this.vendor = vendor;
        this.speed = speed;
        this.model = model;
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

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CPU{id=" + id
                + ", vendor=" + vendor
                + ", speed=" + speed
                + ", model='" + model
                + "'}";
    }
}
